package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Jogo;

public class TelaJogar extends JPanel implements ActionListener {
     public static JLabel jlPontuacao = new JLabel();
     public static JLabel jlVidas = new JLabel("Vidas: ");
     public static JLabel jlVidasImage = new JLabel();
     public TelaJogar() {
          Tela.visor.getContentPane().removeAll();
          jlPontuacao.setFont(new Font("Segoe UI", 1, 20));
          jlVidas.setFont(new Font("Segoe UI", 1, 20));
          jlPontuacao.setPreferredSize(new Dimension(200, 30));
          setBackground(Color.cyan);
          setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
          setLayout(new FlowLayout(FlowLayout.CENTER,200,10));
          JPanel vidas = new JPanel(new FlowLayout(FlowLayout.LEFT));
          vidas.setPreferredSize(new Dimension(300, 30));
          vidas.setBackground(Color.cyan);
          vidas.add(jlVidas);
          vidas.add(jlVidasImage);
          add(vidas,FlowLayout.LEFT);
          add(jlPontuacao);
          Tela.visor.add(this);
          Jogo jogo = new Jogo();
          add(jogo,BorderLayout.CENTER);
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
