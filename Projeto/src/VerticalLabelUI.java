import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicLabelUI;

public class VerticalLabelUI extends BasicLabelUI {

	static {
		labelUI = new VerticalLabelUI(0);
	}

	protected int direcao;

	public VerticalLabelUI(int direcao) {
		super();
		this.direcao = direcao;
	}

	@Override
	public Dimension getPreferredSize(JComponent c) {
		Dimension dim = super.getPreferredSize(c);
		return new Dimension(dim.height, dim.width);
	}

	private static Rectangle paintIconR = new Rectangle();
	private static Rectangle paintTextR = new Rectangle();
	private static Rectangle paintViewR = new Rectangle();
	private static Insets paintViewInsets = new Insets(0, 0, 0, 0);

	@Override
	public void paint(Graphics g, JComponent c) {
		JLabel label = (JLabel) c;
		String text = label.getText();
		Icon icon = (label.isEnabled()) ? label.getIcon() : label.getDisabledIcon();

		if ((icon == null) && (text == null)) {
			return;
		}

		FontMetrics fm = g.getFontMetrics();
		paintViewInsets = c.getInsets(paintViewInsets);

		paintViewR.x = paintViewInsets.left;
		paintViewR.y = paintViewInsets.top;

		if (direcao == 0) {
			paintViewR.x = paintViewInsets.left;
			paintViewR.y = paintViewInsets.top;
			paintViewR.height = c.getHeight() - (paintViewInsets.left + paintViewInsets.right);
			paintViewR.width = c.getWidth();

		} else if (direcao == 1) {
			paintViewR.x = paintViewInsets.left;
			paintViewR.y = paintViewInsets.top;
			paintViewR.height = c.getWidth();
			paintViewR.width = c.getHeight() - (paintViewInsets.top + paintViewInsets.bottom);

		} else if (direcao == 2) {
			paintViewR.x = paintViewInsets.right;
			paintViewR.y = paintViewInsets.bottom;
			paintViewR.height = c.getHeight() - (paintViewInsets.top + paintViewInsets.bottom);
			paintViewR.width = c.getWidth();

		} else if (direcao == 3) {
			paintViewR.x = paintViewInsets.right;
			paintViewR.y = paintViewInsets.bottom;
			paintViewR.height = c.getWidth();
			paintViewR.width = c.getHeight() - (paintViewInsets.top + paintViewInsets.bottom);
		}

		paintIconR.x = paintIconR.y = paintIconR.width = paintIconR.height = 0;
		paintTextR.x = paintTextR.y = paintTextR.width = paintTextR.height = 0;

		String clippedText = layoutCL(label, fm, text, icon, paintViewR, paintIconR, paintTextR);

		Graphics2D g2 = (Graphics2D) g;
		AffineTransform tr = g2.getTransform();

		if (direcao == 0) {
			g2.rotate(0);
			g2.translate(0, 0);
		} else if (direcao == 1) {
			g2.rotate(Math.PI / 2);
			g2.translate(0, -label.getWidth());
		} else if (direcao == 3) {
			g2.rotate(3 * Math.PI / 2);
			g2.translate(-label.getHeight(), 0);
		} else if (direcao == 2) {
			g2.rotate(-Math.PI);
			g2.translate(-label.getWidth(), -label.getHeight());
		}

		if (icon != null) {
			icon.paintIcon(c, g, paintIconR.x, paintIconR.y);
		}

		if (text != null) {
			int textX = paintTextR.x;
			int textY = paintTextR.y + fm.getAscent();

			if (label.isEnabled()) {
				paintEnabledText(label, g, clippedText, textX, textY);
			} else {
				paintDisabledText(label, g, clippedText, textX, textY);
			}
		}
		g2.setTransform(tr);
	}

}