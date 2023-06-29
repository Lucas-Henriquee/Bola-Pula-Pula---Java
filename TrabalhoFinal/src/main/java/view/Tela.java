package view;

import javax.swing.JFrame;

/**
 *
 * @author Lucas Henrique
 */
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
