package view;

import java.awt.*;
import javax.swing.*;

import Game.Jogo;

public class TelaJogar extends JPanel {
     public static JLabel jlPontuacao = new JLabel();
     public static JLabel jlVidasImage = new JLabel();
     public static JLabel jlSpecial = new JLabel();

     public TelaJogar(String NomeDoJogador) {
          Tela.visor.getContentPane().removeAll();
          JLabel jlVidas = new JLabel("Vidas: ");
          jlPontuacao.setFont(new Font("Segoe UI", 1, 20));
          jlVidas.setFont(new Font("Segoe UI", 1, 20));
          jlPontuacao.setPreferredSize(new Dimension(250, 30));
          jlSpecial.setIcon(new ImageIcon("src/main/java/images/Special.png"));
          jlSpecial.setFont(new Font("Segoe UI", 1, 20));
          setBackground(Color.cyan);
          setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
          setLayout(new FlowLayout(FlowLayout.CENTER, 75, 5));
          JPanel vidas = new JPanel(new FlowLayout(FlowLayout.LEADING));
          vidas.setPreferredSize(new Dimension(300, 30));
          vidas.setBackground(Color.cyan);
          vidas.add(jlVidas);
          vidas.add(jlVidasImage);
          add(vidas);
          add(jlSpecial);
          add(jlPontuacao);
          Tela.visor.add(this);
          if (NomeDoJogador.contains("-")) {
               NomeDoJogador=NomeDoJogador.replace("-", "");
               Jogo jogo = new Jogo(NomeDoJogador+"*", 1);
               add(jogo);
               Thread thread = new Thread(jogo);
               thread.start();
          } else {
               Jogo jogo = new Jogo(NomeDoJogador, 0);
               add(jogo);
               Thread thread = new Thread(jogo);
               thread.start();
          }
     }

}
