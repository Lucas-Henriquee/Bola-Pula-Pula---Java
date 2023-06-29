package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JPanel implements ActionListener {

     public TelaInicial() {

          Tela.visor.getContentPane().removeAll();

          setBackground(Color.cyan);
          setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
          setLayout(new GridBagLayout());

          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.CENTER;

          layout.insets = new Insets(50, 0, 50, 0);

          JLabel jlInicio = new JLabel("Bola Pula Pula");
          jlInicio.setForeground(Color.black);
          jlInicio.setFont(new Font("Segoe UI", 1, 90));
          jlInicio.setBounds(230, 50, 750, 75);

          JButton jbIniciar = new JButton("Iniciar");
          jbIniciar.setFont(new Font("Segoe UI", 1, 50));
          jbIniciar.setForeground(Color.black);
          jbIniciar.setBackground(new Color(153, 153, 153));
          jbIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbIniciar.setBounds(480, 800, 250, 80);
          jbIniciar.addActionListener(this);

          JLabel jlImagem = new JLabel();
          jlImagem.setIcon(new ImageIcon("src/main/java/images/ball.png"));
          jlImagem.setBounds(350, 190, 350, 450);

          layout.gridy = 0;
          add(jlInicio, layout);

          layout.gridy = 1;
          add(jlImagem, layout);

          layout.gridy = 2;
          add(jbIniciar, layout);

          Tela.visor.getContentPane().add(this);
          Tela.visor.pack();
          Tela.visor.revalidate();
          Tela.visor.repaint();
          Tela.visor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     }

     @Override
     public void actionPerformed(ActionEvent e) {

          new TelaMenu();

     }
}
