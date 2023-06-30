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

public class TelaCreditos extends JPanel implements ActionListener {

     public TelaCreditos() {

          Tela.visor.getContentPane().removeAll();

          setLayout(null);
          setBackground(Color.cyan);

          JLabel jlCreditos = new JLabel("Créditos");
          jlCreditos.setForeground(Color.black);
          jlCreditos.setFont(new Font("segoe UI", 1, 65));
          jlCreditos.setBounds(new Rectangle(350, 35, 750, 90));

          JTextArea jtaCreditos = new JTextArea();
          jtaCreditos.setEditable(false);
          jtaCreditos.setBackground(Color.cyan);
          jtaCreditos.setFont(new Font("segoe UI", 1, 32));
          jtaCreditos.setBounds(new Rectangle(25, 172, 900, 335));
          jtaCreditos.setText("\n              Este é um trabalho de Orientação a Objetos\n\n      "
                    + "    relizado por Breno Fernandes, Breno Montanha,\n\n                  "
                    + "  Lucas Henrique e Pedro Henrique.\n\n\n\n               "
                    + "Esperamos que tenham gostado do jogo :)");

          JButton jbVoltar = new JButton("Voltar");
          jbVoltar.setFont(new Font("Segoe UI", 1, 35));
          jbVoltar.setForeground(Color.black);
          jbVoltar.setBackground(new Color(153, 153, 153));
          jbVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbVoltar.setBounds(new Rectangle(330, 560, 250, 70));
          jbVoltar.addActionListener(this);

          add(jlCreditos);
          add(jtaCreditos);
          add(jbVoltar);

          Tela.visor.getContentPane().add(this, BorderLayout.CENTER);
          Tela.visor.revalidate();
          Tela.visor.repaint();
          Tela.visor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

     @Override
     public void actionPerformed(ActionEvent e) {

          new TelaMenu();

     }

}
