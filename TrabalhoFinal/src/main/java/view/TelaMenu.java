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
          jlMenu.setFont(new Font("Segoe UI", 1, 80));
          jlMenu.setBounds(new Rectangle(300, 50, 750, 90));

          jbJogar = new JButton("Jogar");
          jbJogar.setFont(new Font("Segoe UI", 1, 50));
          jbJogar.setForeground(Color.black);
          jbJogar.setBackground(new Color(153, 153, 153));
          jbJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbJogar.setBounds(new Rectangle(450, 250, 300, 80));
          jbJogar.addActionListener(this);

          jbRanking = new JButton("Ranking");
          jbRanking.setFont(new Font("Segoe UI", 1, 50));
          jbRanking.setForeground(Color.black);
          jbRanking.setBackground(new Color(153, 153, 153));
          jbRanking.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbRanking.setBounds(new Rectangle(450, 375, 300, 80));
          jbRanking.addActionListener(this);

          jbRegras = new JButton("Regras");
          jbRegras.setFont(new Font("Segoe UI", 1, 50));
          jbRegras.setForeground(Color.black);
          jbRegras.setBackground(new Color(153, 153, 153));
          jbRegras.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbRegras.setBounds(new Rectangle(450, 500, 300, 80));
          jbRegras.addActionListener(this);

          jbCreditos = new JButton("Créditos");
          jbCreditos.setFont(new Font("Segoe UI", 1, 50));
          jbCreditos.setForeground(Color.black);
          jbCreditos.setBackground(new Color(153, 153, 153));
          jbCreditos.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbCreditos.setBounds(new Rectangle(450, 625, 300, 80));
          jbCreditos.addActionListener(this);

          jbSair = new JButton("Sair");
          jbSair.setFont(new Font("Segoe UI", 1, 50));
          jbSair.setForeground(Color.black);
          jbSair.setBackground(new Color(153, 153, 153));
          jbSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbSair.setBounds(new Rectangle(450, 750, 300, 80));
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
