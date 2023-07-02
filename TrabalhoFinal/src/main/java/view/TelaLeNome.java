package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import error.NomeException;
import error.VerificaNome;

public class TelaLeNome extends JPanel implements ActionListener {
    private JTextField textField;
    private JButton jbJogar = new JButton("Jogar");
    private JButton jbVoltar = new JButton("Voltar");

    public TelaLeNome() {
        Tela.visor.getContentPane().removeAll();

        setBackground(Color.cyan);
        setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
        setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        layout.anchor = GridBagConstraints.CENTER;
        layout.insets = new Insets(10, 0, 10, 0);
        JLabel jlInserirNome = new JLabel("Insira seu nome");
        jlInserirNome.setForeground(Color.black);
        jlInserirNome.setFont(new Font("Segoe UI", 1, 40));
        jlInserirNome.setBounds(230, 30, 750, 60);

        JPanel jptextArea = new JPanel();
        jptextArea.setPreferredSize(new Dimension(275, 60));
        jptextArea.setBackground(Color.cyan);
        textField = new JTextField(7);
        textField.setToolTipText(
                "São válidas apenas letras, é necessário começar com uma letra maiúscula e no mínimo três letras");
        textField.setFont(new Font("Segoe UI", 1, 40));
        jptextArea.add(textField);

        jbJogar.setFont(new Font("Segoe UI", 1, 35));
        jbJogar.setForeground(Color.black);
        jbJogar.setBackground(new Color(153, 153, 153));
        jbJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbJogar.setBounds(new Rectangle(330, 555, 250, 70));
        jbJogar.addActionListener(this);

        jbVoltar.setFont(new Font("Segoe UI", 1, 35));
        jbVoltar.setForeground(Color.black);
        jbVoltar.setBackground(new Color(153, 153, 153));
        jbVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbVoltar.setBounds(new Rectangle(330, 555, 250, 70));
        jbVoltar.addActionListener(this);

        JPanel jpBaixo = new JPanel(new GridBagLayout());
        jpBaixo.setBackground(getBackground());
        GridBagConstraints layoutBaixo = new GridBagConstraints();
        layoutBaixo.anchor = GridBagConstraints.CENTER;
        layoutBaixo.insets = new Insets(0, 10, 5, 30);

        JPanel jpPowerUps = new JPanel(new GridBagLayout());
        jpPowerUps.setBackground(getBackground());
        jpPowerUps.setPreferredSize(new Dimension(Tela.WIDTH, 500));
        GridBagConstraints layoutPowerUps = new GridBagConstraints();
        layoutPowerUps.anchor = GridBagConstraints.CENTER;
        layoutPowerUps.insets = new Insets(5, 0, 30, 0);

        layoutPowerUps.gridy = 0;
        JLabel jlPowerUps = new JLabel("  Power Ups:");
        jlPowerUps.setIcon(new ImageIcon("src/main/java/images/rainbow_star.gif"));
        jlPowerUps.setPreferredSize(new Dimension(350, 35));
        jlPowerUps.setFont(new Font("Segoe UI", 1, 40));
        jpPowerUps.add(jlPowerUps, layoutPowerUps);

        layoutPowerUps.gridy = 1;
        JLabel jlDuasBolas = new JLabel("Aumentar 2 Bolas: Será gerado 2 bolas na barra do player");
        jlDuasBolas.setFont(new Font("Segoe UI", 1, 20));
        jpPowerUps.add(jlDuasBolas, layoutPowerUps);

        layoutPowerUps.gridy = 2;
        JLabel jlTriplicaBolas = new JLabel(
                "Triplicar Bolas: Será gerado mais 2 bolas em cada uma das bolas existentes");
        jlTriplicaBolas.setFont(new Font("Segoe UI", 1, 20));
        jpPowerUps.add(jlTriplicaBolas, layoutPowerUps);

        layoutPowerUps.gridy = 3;
        JLabel jlAumentarBarra = new JLabel("Aumentar Barra: A barra será aumentada até o dobro do tamanho original");
        jlAumentarBarra.setFont(new Font("Segoe UI", 1, 20));
        jpPowerUps.add(jlAumentarBarra, layoutPowerUps);

        layoutPowerUps.gridy = 4;
        JLabel jlDiminuirBarra = new JLabel("Diminuir Barra: A barra será reduzida até a metade do tamanho original");
        jlDiminuirBarra.setFont(new Font("Segoe UI", 1, 20));
        jpPowerUps.add(jlDiminuirBarra, layoutPowerUps);

        layoutPowerUps.gridy = 5;
        JLabel jlTrocarControles = new JLabel(
                "Trocar Controles: A cor da barra irá ficar vermelha e os inputs serão trocados");
        jlTrocarControles.setFont(new Font("Segoe UI", 1, 20));
        jpPowerUps.add(jlTrocarControles, layoutPowerUps);

        layoutPowerUps.gridy = 6;
        JLabel jlEspecial = new JLabel("Especial: Você pode usar o especial para eliminar todos os blocos com o Shift");
        jlEspecial.setFont(new Font("Segoe UI", 1, 20));
        jpPowerUps.add(jlEspecial, layoutPowerUps);

        layoutBaixo.gridx = 1;
        layoutBaixo.gridy = 0;
        jpBaixo.add(jlInserirNome, layoutBaixo);

        layoutBaixo.gridy = 1;

        layout.gridx = 1;
        jpBaixo.add(jptextArea, layoutBaixo);

        layoutBaixo.gridx = 2;
        jpBaixo.add(jbJogar, layoutBaixo);

        layout.gridy = 0;
        add(jpPowerUps, layout);

        layout.gridy = 1;
        add(jpBaixo, layout);

        layout.gridy = 2;
        add(jbVoltar, layout);
        Tela.visor.getContentPane().add(this);
        Tela.visor.pack();
        Tela.visor.revalidate();
        Tela.visor.repaint();
        Tela.visor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbJogar) {
            try {
                if (VerificaNome.Checagem(textField.getText())) {
                    new TelaJogar(textField.getText());
                }
            } catch (NomeException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                textField.setText("");
            }
        } else if (e.getSource() == jbVoltar) {
            new TelaMenu();
        }
    }
}
