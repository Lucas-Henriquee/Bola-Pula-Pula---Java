package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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

        JLabel jlParabens = new JLabel("Parabéns " + Jogo.jogador.nome);
        jlParabens.setIcon(new ImageIcon("src/main/java/images/trofeu.png"));
        jlParabens.setForeground(Color.black);
        jlParabens.setFont(new Font("Segoe UI", 1, 40));
        jlParabens.setBounds(230, 30, 750, 60);

        JLabel jlPontos = new JLabel("Você fez " + Jogo.jogador.pontuacao + " pontos");
        jlPontos.setForeground(Color.black);
        jlPontos.setFont(new Font("Segoe UI", 1, 40));
        jlPontos.setBounds(230, 30, 750, 60);

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

        JPanel jpBotoes= new JPanel(new FlowLayout(FlowLayout.CENTER,100,0));
        jpBotoes.setBackground(Color.cyan);
        jpBotoes.setPreferredSize(new Dimension(Tela.WIDTH,80));
        jpBotoes.add(jbMenu);
        jpBotoes.add(jbRanking);
        layout.gridy = 0;
        add(jlParabens, layout);
        layout.gridy = 1;
        add(jlPontos, layout);
        layout.gridy = 2;
        add(jpBotoes, layout);

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
