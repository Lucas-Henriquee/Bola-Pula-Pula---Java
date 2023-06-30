package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaMenu extends JPanel implements ActionListener {

     private JButton jbJogar;
     private JButton jbRanking;
     private JButton jbRegras;
     private JButton jbCreditos;
     private JButton jbSair;

     public TelaMenu() {

          Tela.visor.getContentPane().removeAll();

          setLayout(null);
          setBackground(Color.cyan);

          JLabel jlMenu = new JLabel("Menu do Jogo");
          jlMenu.setForeground(Color.black);
          jlMenu.setFont(new Font("Segoe UI", 1, 65));
          jlMenu.setBounds(new Rectangle(220, 25, 562, 85));

          jbJogar = new JButton("Jogar");
          jbJogar.setFont(new Font("Segoe UI", 1, 35));
          jbJogar.setForeground(Color.black);
          jbJogar.setBackground(new Color(153, 153, 153));
          jbJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbJogar.setBounds(new Rectangle(330, 155, 250, 70));
          jbJogar.addActionListener(this);

          jbRanking = new JButton("Ranking");
          jbRanking.setFont(new Font("Segoe UI", 1, 35));
          jbRanking.setForeground(Color.black);
          jbRanking.setBackground(new Color(153, 153, 153));
          jbRanking.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbRanking.setBounds(new Rectangle(330, 255, 250, 70));
          jbRanking.addActionListener(this);

          jbRegras = new JButton("Regras");
          jbRegras.setFont(new Font("Segoe UI", 1, 35));
          jbRegras.setForeground(Color.black);
          jbRegras.setBackground(new Color(153, 153, 153));
          jbRegras.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbRegras.setBounds(new Rectangle(330, 355, 250, 70));
          jbRegras.addActionListener(this);

          jbCreditos = new JButton("Créditos");
          jbCreditos.setFont(new Font("Segoe UI", 1, 35));
          jbCreditos.setForeground(Color.black);
          jbCreditos.setBackground(new Color(153, 153, 153));
          jbCreditos.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbCreditos.setBounds(new Rectangle(330, 455, 250, 70));
          jbCreditos.addActionListener(this);

          jbSair = new JButton("Sair");
          jbSair.setFont(new Font("Segoe UI", 1, 35));
          jbSair.setForeground(Color.black);
          jbSair.setBackground(new Color(153, 153, 153));
          jbSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbSair.setBounds(new Rectangle(330, 555, 250, 70));
          jbSair.addActionListener(this);

          add(jlMenu);
          add(jbJogar);
          add(jbRanking);
          add(jbRegras);
          add(jbCreditos);
          add(jbSair);

          Tela.visor.getContentPane().add(this, BorderLayout.CENTER);
          Tela.visor.revalidate();
          Tela.visor.repaint();
          Tela.visor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

     @Override
     public void actionPerformed(ActionEvent ae) {
          if (ae.getSource() == jbJogar)
               new TelaJogar();
          else if (ae.getSource() == jbRanking)
               new TelaRanking();
          else if (ae.getSource() == jbRegras)
               new TelaRegras();
          else if (ae.getSource() == jbCreditos)
               new TelaCreditos();
          else {
               Tela.visor.dispose();
               Runtime.getRuntime().exit(0);
          }
     }
}
