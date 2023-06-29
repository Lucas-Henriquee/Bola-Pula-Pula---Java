package view;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TelaRanking extends JPanel implements ActionListener {

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
          jlRanking.setFont(new Font("Segoe UI", 1, 80));
          jlRanking.setBounds(new Rectangle(410, 50, 750, 90));

          JButton jbVoltar = new JButton("Voltar");
          jbVoltar.setFont(new Font("Segoe UI", 1, 50));
          jbVoltar.setForeground(Color.black);
          jbVoltar.setBackground(new Color(153, 153, 153));
          jbVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jbVoltar.setBounds(new Rectangle(450, 800, 300, 80));
          jbVoltar.addActionListener(this);

          String[] colunas = { "Nome", "Pontuação" };

          long a = 9200000000000000000L;
          long b = 9000000000000000000L;
          long c = 8000000000000000000L;
          long d = 3500000000000000000L;

          ArrayList<Object[]> dados = new ArrayList<>();
          dados.add(new Object[] { "Lucas", a });
          dados.add(new Object[] { "BrenoM", b });
          dados.add(new Object[] { "Pedro", c });
          dados.add(new Object[] { "BrenoF", d });

          Collections.sort(dados, Comparator.comparingLong(o -> (long) o[1]));
          Collections.reverse(dados);

          DefaultTableModel tableModel = new DefaultTableModel(colunas, 0) {
               @Override
               public boolean isCellEditable(int row, int column) {
                    return false; // Desabilitando a edição das células
               }
          };

          JTable tabela = new JTable(tableModel);
          Font fonte = tabela.getFont().deriveFont(21f);
          tabela.setFont(fonte);
          tabela.setRowHeight(tabela.getRowHeight() + 10 + 10);

          JTableHeader cabecalho = tabela.getTableHeader();
          Font fonteCabecalho = cabecalho.getFont().deriveFont(28f);
          cabecalho.setFont(fonteCabecalho);

          DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
          cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
          tabela.setDefaultRenderer(Object.class, cellRenderer);

          for (Object[] linha : dados) {
               tableModel.addRow(linha);
          }

          JScrollPane scrollPane = new JScrollPane(tabela);
          scrollPane.setPreferredSize(new java.awt.Dimension(750, 600));

          layout.gridy = 0;
          add(jlRanking, layout);

          layout.gridy = 1;
          add(scrollPane, layout);

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

          new TelaMenu();

     }

}
