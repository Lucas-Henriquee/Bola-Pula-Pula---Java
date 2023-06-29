package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Jogo;

public class TelaJogar extends JPanel implements ActionListener {
     public static JLabel jlPontuacao = new JLabel();
     public static JLabel jlVidas = new JLabel();
     public static JLabel jlVidasImage = new JLabel();
     public TelaJogar() {
          Tela.visor.getContentPane().removeAll();
          jlPontuacao.setFont(new Font("Segoe UI", 1, 20));
          jlVidas.setFont(new Font("Segoe UI", 1, 20));
          jlVidasImage.setBounds(50, 50, 300, 80);
          setLayout(null);
          setBackground(Color.cyan);
          setPreferredSize(new Dimension(WIDTH, HEIGHT));
          setLayout(new BorderLayout());
          add(jlVidas);
          add(jlVidasImage, BorderLayout.NORTH);
          add(jlPontuacao);
          Tela.visor.add(this);
          Jogo jogo = new Jogo();
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
