package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Jogo;
import json.SalvarDados;

public class TelaFimDeJogo extends JPanel implements ActionListener {

    private JButton jbRanking;
    private JButton jbMenu;

    public TelaFimDeJogo() {

        Tela.visor.getContentPane().removeAll();

        setBackground(Color.cyan);
        setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
        setLayout(new GridBagLayout());

        GridBagConstraints layout = new GridBagConstraints();
        layout.anchor = GridBagConstraints.CENTER;

        layout.insets = new Insets(25, 0, 75, 0);

        JLabel jlPerdeu = new JLabel("Você Perdeu");
        jlPerdeu.setForeground(Color.black);
        jlPerdeu.setFont(new Font("Segoe UI", 1, 80));
        jlPerdeu.setBounds(230, 30, 750, 60);

        jbMenu = new JButton("Menu");
        jbMenu.setFont(new Font("Segoe UI", 1, 40));
        jbMenu.setForeground(Color.black);
        jbMenu.setBackground(new Color(153, 153, 153));
        jbMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbMenu.setBounds(480, 800, 250, 70);
        jbMenu.addActionListener(this);

        jbRanking = new JButton("Ranking");
        jbRanking.setFont(new Font("Segoe UI", 1, 40));
        jbRanking.setForeground(Color.black);
        jbRanking.setBackground(new Color(153, 153, 153));
        jbRanking.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbRanking.setBounds(480, 800, 250, 70);
        jbRanking.addActionListener(this);

        layout.gridy = 0;
        add(jlPerdeu, layout);
        layout.gridy = 1;
        add(jbMenu, layout);
        layout.gridy = 2;
        add(jbRanking, layout);

        SalvarDados.saveToJsonFile(Jogo.jogador.nome, Jogo.jogador.pontuacao, "src/main/java/Database/Dados.json");

        Tela.visor.add(this);
        Tela.visor.revalidate();
        Tela.visor.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbMenu)
            new TelaMenu();
        else if (ae.getSource() == jbRanking)
            new TelaRanking();
    }

}
