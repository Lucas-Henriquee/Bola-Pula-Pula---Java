package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import Jogo.Jogo;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author lucas_henrique
 */
public class Tela implements ActionListener {

    private JFrame tela;

    private JButton jbIniciar;
    private JButton jbJogar;
    private JButton jbRanking;
    private JButton jbRegras;
    private JButton jbCreditos;
    private JButton jbVoltar;
    private JButton jbSair;

    private final int HEIGHT = 1000;
    private final int WIDTH = 1200;

    public void inicializa() {

        tela = new JFrame("Bola Pula Pula");
        tela.setSize(WIDTH, HEIGHT);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
        tela.setResizable(false);
        telaInicial();

    }

    public void telaInicial() {

        JPanel jpInicio = new JPanel();
        jpInicio.setBackground(Color.cyan);
        jpInicio.setPreferredSize(new Dimension(1200,1000));
        jpInicio.setLayout(new GridBagLayout());
        
        GridBagConstraints a = new GridBagConstraints();
        a.anchor = GridBagConstraints.CENTER;
        
        a.insets = new Insets(50, 0, 50, 0);
        
        JLabel jlInicio = new JLabel("Bola Pula Pula");
        jlInicio.setForeground(Color.black);
        jlInicio.setFont(new Font("Segoe UI", 1, 90));
        jlInicio.setBounds(230, 50, 750, 75);
         
        jbIniciar = new JButton("Iniciar");
        jbIniciar.setFont(new Font("Segoe UI", 1, 50));
        jbIniciar.setForeground(Color.black);
        jbIniciar.setBackground(new Color(153, 153, 153));
        jbIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbIniciar.setBounds(480, 800, 250, 80);
        jbIniciar.addActionListener(this);
        
        JLabel jlImagem = new JLabel();
        jlImagem.setIcon(new ImageIcon("src/main/java/Images/ball_brick.png"));
        jlImagem.setBounds(350,190,550,600);
        
        a.gridy = 0;
        jpInicio.add(jlInicio,a);
        
        a.gridy = 1;
        jpInicio.add(jlImagem,a);
        
        a.gridy = 2;
        jpInicio.add(jbIniciar,a);

        tela.getContentPane().add(jpInicio);
        tela.pack();
        tela.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void telaMenu() {

        JPanel jpMenu = new JPanel();
        jpMenu.setLayout(null);
        jpMenu.setBackground(Color.cyan);

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

        jbCreditos = new JButton("Creditos");
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

        jpMenu.add(jlMenu);
        jpMenu.add(jbJogar);
        jpMenu.add(jbRanking);
        jpMenu.add(jbRegras);
        jpMenu.add(jbCreditos);
        jpMenu.add(jbSair);

        tela.getContentPane().add(jpMenu, BorderLayout.CENTER);
        tela.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void telaJogar() {

        JPanel jpJogar = new JPanel();
        jpJogar.setLayout(null);
        jpJogar.setBackground(Color.cyan);
        Jogo jogo = new Jogo();
        tela.getContentPane().add(jogo);
        tela.pack();
        Thread thread= new Thread(jogo);
        thread.start();
        
    }

    private void telaRanking() {

        JPanel jpRanking = new JPanel();
        jpRanking.setLayout(null);
        jpRanking.setBackground(Color.cyan);

        JLabel jlRanking = new JLabel("Ranking");
        jlRanking.setForeground(Color.black);
        jlRanking.setFont(new Font("Segoe UI", 1, 80));
        jlRanking.setBounds(new Rectangle(410, 50, 750, 90));

        jbVoltar = new JButton("Voltar");
        jbVoltar.setFont(new Font("Segoe UI", 1, 50));
        jbVoltar.setForeground(Color.black);
        jbVoltar.setBackground(new Color(153, 153, 153));
        jbVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbVoltar.setBounds(new Rectangle(450, 800, 300, 80));
        jbVoltar.addActionListener(this);

        jpRanking.add(jlRanking);
        jpRanking.add(jbVoltar);

        tela.getContentPane().add(jpRanking, BorderLayout.CENTER);
        tela.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void telaRegras() {

        JPanel jpRegras = new JPanel();
        jpRegras.setLayout(null);
        jpRegras.setBackground(Color.cyan);

        JLabel jlRegras = new JLabel("Regras");
        jlRegras.setForeground(Color.black);
        jlRegras.setFont(new Font("segoe UI", 1, 80));
        jlRegras.setBounds(new Rectangle(450, 50, 750, 90));

        JTextArea jtaRegras = new JTextArea();
        jtaRegras.setEditable(false);
        jtaRegras.setBackground(Color.cyan);
        jtaRegras.setFont(new Font("segoe UI", 1, 30));
        jtaRegras.setBounds(new Rectangle(5, 275, 1200, 480));
        jtaRegras.setText("             O jogador controla uma barra que se move lateralmente. "
                + "\n\nO objetivo é quebrar os blcos que são gerados de tempos em tempos.\n\n  "
                + "            O jogador possui 3 vidas ao longo de cada partida.\n\n    "
                + "  As vidas são perdidas quando o tabuleiro não possui mais bolas.\n\n"
                + "A cada bloco quebrado a pontuação será acrescida na pontuação total.");

        jbVoltar = new JButton("Voltar");
        jbVoltar.setFont(new Font("Segoe UI", 1, 50));
        jbVoltar.setForeground(Color.black);
        jbVoltar.setBackground(new Color(153, 153, 153));
        jbVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbVoltar.setBounds(new Rectangle(450, 800, 300, 80));
        jbVoltar.addActionListener(this);

        jpRegras.add(jlRegras);
        jpRegras.add(jtaRegras);
        jpRegras.add(jbVoltar);

        tela.getContentPane().add(jpRegras, BorderLayout.CENTER);
        tela.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void telaCreditos() {

        JPanel jpCreditos = new JPanel();
        jpCreditos.setLayout(null);
        jpCreditos.setBackground(Color.cyan);

        JLabel jlCreditos = new JLabel("Creditos");
        jlCreditos.setForeground(Color.black);
        jlCreditos.setFont(new Font("segoe UI", 1, 80));
        jlCreditos.setBounds(new Rectangle(420, 50, 750, 90));

        JTextArea jtaCreditos = new JTextArea();
        jtaCreditos.setEditable(false);
        jtaCreditos.setBackground(Color.cyan);
        jtaCreditos.setFont(new Font("segoe UI", 1, 35));
        jtaCreditos.setBounds(new Rectangle(5, 245, 1200, 480));
        jtaCreditos.setText("\n              Este é um trabalho de Orientação a Objetos\n\n      "
                + "    relizado por Breno Fernandes, Breno Montanha,\n\n                  "
                + "  Lucas Henrique e Pedro Henrique.\n\n\n\n               "
                + "Esperamos que tenham gostado do jogo :)");

        jbVoltar = new JButton("Voltar");
        jbVoltar.setFont(new Font("Segoe UI", 1, 50));
        jbVoltar.setForeground(Color.black);
        jbVoltar.setBackground(new Color(153, 153, 153));
        jbVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbVoltar.setBounds(new Rectangle(450, 800, 300, 80));
        jbVoltar.addActionListener(this);

        jpCreditos.add(jlCreditos);
        jpCreditos.add(jtaCreditos);
        jpCreditos.add(jbVoltar);

        tela.getContentPane().add(jpCreditos, BorderLayout.CENTER);
        tela.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbIniciar) {
            tela.getContentPane().removeAll();
            telaMenu();
            tela.revalidate();
            tela.repaint();
        } else if (ae.getSource() == jbJogar) {
            tela.getContentPane().removeAll();
            telaJogar();
            tela.revalidate();
            tela.repaint();
        } else if (ae.getSource() == jbRanking) {
            tela.getContentPane().removeAll();
            telaRanking();
            tela.revalidate();
            tela.repaint();
        } else if (ae.getSource() == jbVoltar) {
            tela.getContentPane().removeAll();
            telaMenu();
            tela.revalidate();
            tela.repaint();
        } else if (ae.getSource() == jbRegras) {
            tela.getContentPane().removeAll();
            telaRegras();
            tela.revalidate();
            tela.repaint();
        } else if (ae.getSource() == jbCreditos) {
            tela.getContentPane().removeAll();
            telaCreditos();
            tela.revalidate();
            tela.repaint();
        } else {
            tela.dispose();
            Runtime.getRuntime().exit(0);
        }
    }

}
