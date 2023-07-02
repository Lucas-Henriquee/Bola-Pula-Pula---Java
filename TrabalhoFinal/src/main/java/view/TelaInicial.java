//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaInicial extends JPanel implements ActionListener {

     public TelaInicial() {

          Tela.visor.getContentPane().removeAll();

          setBackground(Color.cyan);
          setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
          setLayout(new GridBagLayout());

          GridBagConstraints layout = new GridBagConstraints();
          layout.anchor = GridBagConstraints.CENTER;

          layout.insets = new Insets(20, 0, 20, 0);

          JLabel jlInicio = new JLabel("Bola Pula Pula");
          jlInicio.setForeground(Color.black);
          jlInicio.setFont(new Font("Segoe UI", 1, 80));
          jlInicio.setBounds(230, 30, 750, 60);

          JButton jbIniciar = new JButton("Iniciar");
          jbIniciar.setFont(new Font("Segoe UI", 1, 40));
          jbIniciar.setForeground(Color.black);
          jbIniciar.setBackground(new Color(153, 153, 153));
          jbIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbIniciar.setBounds(480, 800, 250, 70);
          jbIniciar.addActionListener(this);

          JLabel jlImagem = new JLabel();
          jlImagem.setIcon(new ImageIcon("src/main/java/images/ball.png"));
          jlImagem.setLocation(350, 270);

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
