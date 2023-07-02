//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import error.*;
import json.*;
import json.LimparDados;

public class TelaRanking extends JPanel implements ActionListener {

     private JButton jbLimpar;
     private JButton jbVoltar;

     public TelaRanking() {

          Tela.visor.getContentPane().removeAll();

          setBackground(Color.cyan);
          setPreferredSize(new Dimension(Tela.WIDTH, Tela.HEIGHT));
          setLayout(new GridBagLayout());

          GridBagConstraints layout = new GridBagConstraints();

          layout.anchor = GridBagConstraints.CENTER;
          layout.insets = new Insets(25, 0, 25, 0);

          JLabel jlRanking = new JLabel("Ranking");
          jlRanking.setForeground(Color.black);
          jlRanking.setFont(new Font("Segoe UI", 1, 65));
          jlRanking.setBounds(new Rectangle(340, 30, 750, 80));

          jbVoltar = new JButton("Voltar");
          jbVoltar.setFont(new Font("Segoe UI", 1, 35));
          jbVoltar.setForeground(Color.black);
          jbVoltar.setBackground(new Color(153, 153, 153));
          jbVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbVoltar.setBounds(new Rectangle(325, 560, 250, 70));
          jbVoltar.addActionListener(this);

          jbLimpar = new JButton("Limpar");
          jbLimpar.setFont(new Font("Segoe UI", 1, 35));
          jbLimpar.setForeground(Color.black);
          jbLimpar.setBackground(new Color(153, 153, 153));
          jbLimpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbLimpar.setBounds(new Rectangle(325, 560, 250, 70));
          jbLimpar.addActionListener(this);

          String[] colunas = { "Nome", "Pontuação" };

          ArrayList<Object[]> dados = CarregarDados.readFromJsonFile("src/main/java/Database/Dados.json");

          DefaultTableModel tableModel = new DefaultTableModel(colunas, 0) {
               @Override
               public boolean isCellEditable(int row, int column) {
                    return false;
               }
          };

          JTable tabela = new JTable(tableModel);
          Font fonte = tabela.getFont().deriveFont(18f);
          tabela.setFont(fonte);
          tabela.setRowHeight(tabela.getRowHeight() + 10 + 10);

          JTableHeader cabecalho = tabela.getTableHeader();
          Font fonteCabecalho = cabecalho.getFont().deriveFont(22f);
          cabecalho.setFont(fonteCabecalho);

          DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
          cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
          tabela.setDefaultRenderer(Object.class, cellRenderer);

          JScrollPane scrollPane = new JScrollPane(tabela);
          scrollPane.setPreferredSize(new java.awt.Dimension(500, 357));

          if (dados != null) {
               for (Object[] linha : dados) {
                    tableModel.addRow(linha);
               }
          }

          JPanel jpBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 0));
          jpBotoes.setBackground(Color.cyan);
          jpBotoes.setPreferredSize(new Dimension(Tela.WIDTH, 80));

          jpBotoes.add(jbVoltar);
          jpBotoes.add(jbLimpar);

          layout.gridy = 0;

          add(jlRanking, layout);

          layout.gridy = 1;
          add(scrollPane, layout);

          layout.gridy = 2;
          add(jpBotoes, layout);

          Tela.visor.getContentPane().add(this);
          Tela.visor.pack();
          Tela.visor.revalidate();
          Tela.visor.repaint();
          Tela.visor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

     @Override
     public void actionPerformed(ActionEvent e) {

          if (e.getSource() == jbVoltar)
               new TelaMenu();

          else if (e.getSource() == jbLimpar) {
               try {
                    if (VerificaArquivo.validacao("src/main/java/Database/Dados.json")) {
                         LimparDados.cleanJsonFile("src/main/java/Database/Dados.json");
                         new TelaRanking();
                    }
               } catch (ArquivoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
               }
          }

     }

}
