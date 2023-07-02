//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package view;

import javax.swing.*;

public class Tela {

     public static JFrame visor;

     public static final int HEIGHT = 700;
     public static final int WIDTH = 900;

     public void inicializa() {

          visor = new JFrame("Bola Pula Pula");
          visor.setSize(WIDTH, HEIGHT);
          visor.setVisible(true);
          visor.setLocationRelativeTo(null);
          visor.setResizable(false);
          new TelaInicial();
     }

}
