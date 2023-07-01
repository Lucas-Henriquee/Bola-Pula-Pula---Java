package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Jogo;

public class TelaJogar extends JPanel implements ActionListener {
     public static JLabel jlPontuacao = new JLabel();
     public static JLabel jlVidasImage = new JLabel();
     public static JLabel jlSpecial = new JLabel();
     public TelaJogar() {
          Tela.visor.getContentPane().removeAll();
          JLabel jlVidas = new JLabel("Vidas: ");
          jlPontuacao.setFont(new Font("Segoe UI", 1, 20));
          jlVidas.setFont(new Font("Segoe UI", 1, 20));
          jlPontuacao.setPreferredSize(new Dimension(250, 30));
          jlSpecial.setIcon(new ImageIcon("src/main/java/images/Special.png"));
          jlSpecial.setFont(new Font("Segoe UI", 1, 20));
          setBackground(Color.cyan);
          setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
          setLayout(new FlowLayout(FlowLayout.CENTER,100,0));
          JPanel vidas = new JPanel(new FlowLayout(FlowLayout.LEADING));
          vidas.setPreferredSize(new Dimension(250, 30));
          vidas.setBackground(Color.cyan);
          vidas.add(jlVidas);
          vidas.add(jlVidasImage);
          add(vidas);
          add(jlSpecial);
          add(jlPontuacao);
          Tela.visor.add(this);
          Jogo jogo = new Jogo("Teste",1);
          add(jogo);
          Thread thread = new Thread(jogo);
          thread.start();
          Tela.visor.revalidate();
          Tela.visor.repaint();
     }

     @Override
     public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
     }
}
