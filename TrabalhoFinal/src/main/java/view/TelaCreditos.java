//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaCreditos extends JPanel implements ActionListener {

    public TelaCreditos() {

        Tela.visor.getContentPane().removeAll();

        setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
        setLayout(new GridBagLayout());
        setBackground(Color.cyan);

        GridBagConstraints layout = new GridBagConstraints();
        layout.anchor = GridBagConstraints.CENTER;
        layout.insets = new java.awt.Insets(15, 0, 25, 0);

        JLabel jlCreditos = new JLabel("Créditos");
        jlCreditos.setForeground(Color.black);
        jlCreditos.setFont(new Font("segoe UI", 1, 65));
        jlCreditos.setBounds(new Rectangle(320, 15, 750, 90));

        JTextArea jtaCreditos = new JTextArea();
        jtaCreditos.setEditable(false);
        jtaCreditos.setBackground(Color.cyan);
        jtaCreditos.setFont(new Font("segoe UI", 1, 28));
        jtaCreditos.setBounds(new Rectangle(0, 160, 900, 335));
        jtaCreditos.setText("\n      Este é um trabalho de Orientação a Objetos\n\n   "
                + " realizado por Breno Fernandes, Breno Montanha,\n\n              "
                + "  Lucas Henrique e Pedro Henrique.\n\n        "
                + "Esperamos que tenham gostado do jogo :)");

        JButton jbVoltar = new JButton("Voltar");
        jbVoltar.setFont(new Font("Segoe UI", 1, 35));
        jbVoltar.setForeground(Color.black);
        jbVoltar.setBackground(new Color(153, 153, 153));
        jbVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbVoltar.setBounds(new Rectangle(330, 560, 250, 70));
        jbVoltar.addActionListener(this);

        JLabel espaco = new JLabel();

        layout.gridy = 0;
        add(jlCreditos, layout);

        layout.gridy = 1;
        add(jtaCreditos, layout);

        layout.gridy = 2;
        add(espaco, layout);

        layout.gridy = 3;
        add(jbVoltar, layout);

        Tela.visor.getContentPane().add(this);
        Tela.visor.revalidate();
        Tela.visor.repaint();
        Tela.visor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new TelaMenu();

    }

}
