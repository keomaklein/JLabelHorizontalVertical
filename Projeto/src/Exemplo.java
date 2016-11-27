import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Exemplo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exemplo window = new Exemplo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Exemplo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 174, 176);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_1 = new JLabel("Meu Texto 1");
		lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_1.setUI(new VerticalLabelUI(0));
		lbl_1.setBounds(37, 11, 95, 14);
		frame.getContentPane().add(lbl_1);
		
		JLabel lbl_2 = new JLabel("Meu Texto 2");
		lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_2.setUI(new VerticalLabelUI(1));
		lbl_2.setBounds(135, 31, 14, 79);
		frame.getContentPane().add(lbl_2);
		
		JLabel lbl_3 = new JLabel("Meu Texto 3");
		lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_3.setUI(new VerticalLabelUI(2));
		lbl_3.setBounds(37, 112, 95, 14);
		frame.getContentPane().add(lbl_3);
		
		JLabel lbl_4 = new JLabel("Meu Texto 4");
		lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_4.setUI(new VerticalLabelUI(3));
		lbl_4.setBounds(13, 31, 14, 79);
		frame.getContentPane().add(lbl_4);
	}
}
