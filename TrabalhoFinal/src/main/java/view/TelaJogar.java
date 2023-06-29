package view;

public class TelaJogar {
     public TelaJogar() {
          
          Tela.visor.getContentPane().removeAll();

          Tela.visor.revalidate();
          Tela.visor.repaint();
     }
}
