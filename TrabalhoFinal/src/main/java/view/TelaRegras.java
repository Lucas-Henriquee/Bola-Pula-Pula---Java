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
import javax.swing.JTextArea;

public class TelaRegras extends JPanel implements ActionListener {

     public TelaRegras() {

          Tela.visor.getContentPane().removeAll();

          setLayout(null);
          setBackground(Color.cyan);

          JLabel jlRegras = new JLabel("Regras");
          jlRegras.setForeground(Color.black);
          jlRegras.setFont(new Font("segoe UI", 1, 65));
          jlRegras.setBounds(new Rectangle(340, 30, 750, 90));

          JTextArea jtaRegras = new JTextArea();
          jtaRegras.setEditable(false);
          jtaRegras.setBackground(Color.cyan);
          jtaRegras.setFont(new Font("segoe UI", 1, 25));
          jtaRegras.setBounds(new Rectangle(35, 180, 900, 335));
          jtaRegras.setText("             O jogador controla uma barra que se move lateralmente. "
                    + "\n\nO objetivo é quebrar os blcos que são gerados de tempos em tempos.\n\n  "
                    + "            O jogador possui 3 vidas ao longo de cada partida.\n\n    "
                    + "  As vidas são perdidas quando o tabuleiro não possui mais bolas.\n\n"
                    + "A cada bloco quebrado a pontuação será acrescida na pontuação total.");

          JButton jbVoltar = new JButton("Voltar");
          jbVoltar.setFont(new Font("Segoe UI", 1, 35));
          jbVoltar.setForeground(Color.black);
          jbVoltar.setBackground(new Color(153, 153, 153));
          jbVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbVoltar.setBounds(new Rectangle(325, 560, 250, 70));
          jbVoltar.addActionListener(this);

          add(jlRegras);
          add(jtaRegras);
          add(jbVoltar);

          Tela.visor.getContentPane().add(this, BorderLayout.CENTER);
          Tela.visor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          Tela.visor.revalidate();
          Tela.visor.repaint();

     }

     @Override
     public void actionPerformed(ActionEvent e) {

          new TelaMenu();

     }
}
