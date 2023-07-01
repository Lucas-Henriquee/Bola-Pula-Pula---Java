package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaRegras extends JPanel implements ActionListener {

    public TelaRegras() {

        Tela.visor.getContentPane().removeAll();

        setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
        setLayout(new GridBagLayout());
        setBackground(Color.cyan);

        GridBagConstraints layout = new GridBagConstraints();
        layout.anchor = GridBagConstraints.CENTER;
        layout.insets = new Insets(15, 100, 40, 100);

        JLabel jlRegras = new JLabel("Regras");
        jlRegras.setForeground(Color.black);
        jlRegras.setFont(new Font("segoe UI", 1, 65));
        jlRegras.setBounds(new Rectangle(330, 0, 750, 90));

        JTextArea jtaRegras = new JTextArea();
        jtaRegras.setEditable(false);
        jtaRegras.setBackground(Color.cyan);
        jtaRegras.setFont(new Font("segoe UI", 1, 25));
        jtaRegras.setBounds(new Rectangle(5, 180, 900, 335));
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
        jbVoltar.setBounds(new Rectangle(450, 560, 250, 70));
        jbVoltar.addActionListener(this);

        layout.gridy = 0;
        add(jlRegras, layout);

        layout.gridy = 1;
        add(jtaRegras, layout);

        layout.gridy = 2;
        add(jbVoltar, layout);

        Tela.visor.getContentPane().add(this);
        Tela.visor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Tela.visor.revalidate();
        Tela.visor.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new TelaMenu();

    }
}
