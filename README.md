# JLabelHorizontalVertical
Classe para rotacionar o JLabel em 0°, 90°, 180° e 270°.

Esta é uma simple implementação para rotacionar o JLabel em 0°, 90°, 180° e 270°.
Para utiliza-la basta seguir o seguinte exemplo:

JLabel meuLabel = new JLabel("Meu texto");
meuLabel.setUI(new VerticalLabelUI(direcaoDesejada));
add(meuLabel);

Na variavel "direcaoDesejada" deve-se usar os seguintes valores inteiros: 
0 para rotacionar 0°, 1 para rotacionar 90°, 2 para rotacionar 180° e 3 para rotacionar 270°.
