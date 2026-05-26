package POO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.*;

public class Readers {
    private JFrame frame;

    public Readers() {
        frame = new JFrame("Alexandria do Manfrine — Registro de leitores");
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        panel.setBackground(Color.LIGHT_GRAY);

        ArrayList<String[]> MemoryReaderList = new ArrayList<String[]>();

        String[] colunas = {"Nome", "ID", "Data de Empréstimo", "Relação", "Livro Alugado", "Prazo", "Devolvido"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50, 380, 780, 170);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(50, 120, 100, 20);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(270, 120, 100, 20);

        JLabel lblDataEmprestimo = new JLabel("Data de Empréstimo");
        lblDataEmprestimo.setBounds(490, 120, 150, 20);

        JLabel lblRelacao = new JLabel("Relação");
        lblRelacao.setBounds(660, 120, 100, 20);

        JLabel lblLivroAlugado = new JLabel("Livro Alugado");
        lblLivroAlugado.setBounds(50, 200, 120, 20);

        JLabel lblPrazo = new JLabel("Prazo");
        lblPrazo.setBounds(270, 200, 100, 20);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(50, 140, 200, 30);

        JTextField txtId = new JTextField();
        txtId.setBounds(270, 140, 200, 30);

        JTextField txtDataEmprestimo = new JTextField();
        txtDataEmprestimo.setBounds(490, 140, 150, 30);

        JTextField txtRelacao = new JTextField();
        txtRelacao.setBounds(660, 140, 150, 30);

        JTextField txtLivroAlugado = new JTextField();
        txtLivroAlugado.setBounds(50, 220, 200, 30);

        JTextField txtPrazo = new JTextField();
        txtPrazo.setBounds(270, 220, 200, 30);

        JCheckBox chkDevolvido = new JCheckBox("Devolvido");
        chkDevolvido.setBounds(490, 220, 120, 30);
        chkDevolvido.setBackground(Color.LIGHT_GRAY);
        chkDevolvido.setSelected(false);

        String[] options = {"Cadastrar", "Modificar", "Excluir", "Pesquisar"};
        JComboBox box = new JComboBox(options);
        box.setBounds(50, 20, 150, 30);

        JButton confirmButton = new JButton("Confirmar");
        confirmButton.setBounds(50, 60, 150, 30);

        JButton btnVoltar = new JButton("← Voltar");
        btnVoltar.setBounds(720, 20, 150, 30);

        confirmButton.addActionListener(e -> {
            if (box.getSelectedItem().equals("Cadastrar")) {
                String nome = txtNome.getText().trim();
                String id = txtId.getText().trim();
                String dataEmprestimo = txtDataEmprestimo.getText().trim();
                String relacao = txtRelacao.getText().trim();
                String livroAlugado = txtLivroAlugado.getText().trim();
                String prazo = txtPrazo.getText().trim();
                String devolvido = chkDevolvido.isSelected() ? "Sim" : "Não";

                if (!nome.isEmpty()) {
                    String[] leitor = {nome, id, dataEmprestimo, relacao, livroAlugado, prazo, devolvido};
                    MemoryReaderList.add(leitor);
                    tableModel.addRow(leitor);
                    JOptionPane.showMessageDialog(frame, "Novo leitor adicionado.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha ao menos o nome.");
                }

            } else if (box.getSelectedItem().equals("Modificar")) {
                int row = table.getSelectedRow();
                String nome = txtNome.getText().trim();
                if (row != -1 && !nome.isEmpty()) {
                    String devolvido = chkDevolvido.isSelected() ? "Sim" : "Não";
                    String[] leitor = {
                            nome,
                            txtId.getText().trim(),
                            txtDataEmprestimo.getText().trim(),
                            txtRelacao.getText().trim(),
                            txtLivroAlugado.getText().trim(),
                            txtPrazo.getText().trim(),
                            devolvido
                    };
                    MemoryReaderList.set(row, leitor);
                    for (int i = 0; i < leitor.length; i++) {
                        tableModel.setValueAt(leitor[i], row, i);
                    }
                    JOptionPane.showMessageDialog(frame, "Leitor modificado.");
                } else if (row == -1) {
                    JOptionPane.showMessageDialog(frame, "Selecione um leitor para modificá-lo.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha ao menos o nome.");
                }

            } else if (box.getSelectedItem().equals("Excluir")) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    MemoryReaderList.remove(row);
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(frame, "Leitor excluído.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um leitor para excluí-lo.");
                }

            } else if (box.getSelectedItem().equals("Pesquisar")) {
                String nome = txtNome.getText().trim();
                boolean found = false;
                for (int i = 0; i < MemoryReaderList.size(); i++) {
                    if (MemoryReaderList.get(i)[0].equalsIgnoreCase(nome)) {
                        table.setRowSelectionInterval(i, i);
                        JOptionPane.showMessageDialog(frame, "Leitor encontrado.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame, "Leitor não encontrado.");
                }
            }
        });

        btnVoltar.addActionListener(e -> frame.setVisible(false));

        panel.add(box);
        panel.add(confirmButton);
        panel.add(btnVoltar);

        frame.add(lblNome);
        frame.add(lblId);
        frame.add(lblDataEmprestimo);
        frame.add(lblRelacao);
        frame.add(lblLivroAlugado);
        frame.add(lblPrazo);
        frame.add(txtNome);
        frame.add(txtId);
        frame.add(txtDataEmprestimo);
        frame.add(txtRelacao);
        frame.add(txtLivroAlugado);
        frame.add(txtPrazo);
        frame.add(chkDevolvido);
        frame.add(scroll);
        frame.add(panel);

        frame.setSize(900, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(false);
    }

    public void showFrame() {
        frame.setVisible(true);
    }
}