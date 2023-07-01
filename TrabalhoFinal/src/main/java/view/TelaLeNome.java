package view;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;

public class TelaLeNome extends JPanel implements ActionListener {
    private JTextField textField;

    public TelaLeNome() {
        Tela.visor.getContentPane().removeAll();

        setBackground(Color.cyan);
        setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
        setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        layout.anchor = GridBagConstraints.CENTER;
        layout.insets = new Insets(20, 0, 20, 0);
        JLabel jlInicio = new JLabel("Insira seu nome");
        jlInicio.setForeground(Color.black);
        jlInicio.setFont(new Font("Segoe UI", 1, 40));
        jlInicio.setBounds(230, 30, 750, 60);

        JPanel jptextArea = new JPanel();
        jptextArea.setPreferredSize(new Dimension(750, 60));
        jptextArea.setBackground(Color.cyan);
        textField = new JTextField(10);
        textField.setFont(new Font("Segoe UI", 1, 40));
        jptextArea.add(textField);

        JButton jbJogar = new JButton("Jogar");
        jbJogar.setBounds(230, 60, 750, 60);
        jbJogar.setFont(new Font("Segoe UI", 1, 35));
        jbJogar.setForeground(Color.black);
        jbJogar.setBackground(new Color(153, 153, 153));
        jbJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbJogar.setBounds(new Rectangle(330, 555, 250, 70));
        jbJogar.addActionListener(this);

        layout.gridy = 0;
        add(jlInicio, layout);
        layout.gridy = 1;
        add(jptextArea, layout);
        layout.gridy = 2;
        add(jbJogar, layout);
        Tela.visor.getContentPane().add(this);
        Tela.visor.pack();
        Tela.visor.revalidate();
        Tela.visor.repaint();
        Tela.visor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Nome = textField.getText();
        String NomeRegex = "^[A-Z-][A-Za-z]*$";
        Pattern pattern = Pattern.compile(NomeRegex);
        Matcher matcher = pattern.matcher(Nome);

        if (matcher.matches()) {
            new TelaJogar(Nome);
        } else {
            JOptionPane.showMessageDialog(null,"Você Inseriu um caractere inválido");
            textField.setText("");
        }
    }
}
