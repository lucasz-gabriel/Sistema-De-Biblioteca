package POO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.*;

public class Book {
    private JFrame frame;

    public Book() {
        frame = new JFrame("Alexandria do Manfrine — Registro de livros");
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        panel.setBackground(Color.LIGHT_GRAY);

        ArrayList<String[]> MemoryBookList = new ArrayList<String[]>();

        String[] colunas = {"Título", "Autor", "Ano", "Editora", "Nº Páginas", "Último Empréstimo", "Disponível"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50, 380, 780, 170);

        JLabel lblTitulo = new JLabel("Título");
        lblTitulo.setBounds(50, 120, 100, 20);

        JLabel lblAutor = new JLabel("Autor");
        lblAutor.setBounds(270, 120, 100, 20);

        JLabel lblAno = new JLabel("Ano");
        lblAno.setBounds(490, 120, 100, 20);

        JLabel lblEditora = new JLabel("Editora");
        lblEditora.setBounds(610, 120, 100, 20);

        JLabel lblPaginas = new JLabel("Nº Páginas");
        lblPaginas.setBounds(50, 200, 100, 20);

        JLabel lblEmprestimo = new JLabel("Último Empréstimo");
        lblEmprestimo.setBounds(170, 200, 150, 20);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(50, 140, 200, 30);

        JTextField txtAutor = new JTextField();
        txtAutor.setBounds(270, 140, 200, 30);

        JTextField txtAno = new JTextField();
        txtAno.setBounds(490, 140, 100, 30);

        JTextField txtEditora = new JTextField();
        txtEditora.setBounds(610, 140, 180, 30);

        JTextField txtPaginas = new JTextField();
        txtPaginas.setBounds(50, 220, 100, 30);

        JTextField txtEmprestimo = new JTextField();
        txtEmprestimo.setBounds(170, 220, 150, 30);

        JCheckBox chkDisponivel = new JCheckBox("Disponível");
        chkDisponivel.setBounds(340, 220, 120, 30);
        chkDisponivel.setBackground(Color.LIGHT_GRAY);
        chkDisponivel.setSelected(true);

        String[] options = {"Cadastrar", "Modificar", "Excluir", "Pesquisar"};
        JComboBox box = new JComboBox(options);
        box.setBounds(50, 20, 150, 30);

        JButton confirmButton = new JButton("Confirmar");
        confirmButton.setBounds(50, 60, 150, 30);

        JButton btnVoltar = new JButton("← Voltar");
        btnVoltar.setBounds(720, 20, 150, 30);

        confirmButton.addActionListener(e -> {
            if (box.getSelectedItem().equals("Cadastrar")) {
                String titulo = txtTitulo.getText().trim();
                String autor = txtAutor.getText().trim();
                String ano = txtAno.getText().trim();
                String editora = txtEditora.getText().trim();
                String paginas = txtPaginas.getText().trim();
                String emprestimo = txtEmprestimo.getText().trim();
                String disponivel = chkDisponivel.isSelected() ? "Sim" : "Não";

                if (!titulo.isEmpty()) {
                    String[] livro = {titulo, autor, ano, editora, paginas, emprestimo, disponivel};
                    MemoryBookList.add(livro);
                    tableModel.addRow(livro);
                    JOptionPane.showMessageDialog(frame, "Novo livro adicionado.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha ao menos o título.");
                }

            } else if (box.getSelectedItem().equals("Modificar")) {
                int row = table.getSelectedRow();
                String titulo = txtTitulo.getText().trim();
                if (row != -1 && !titulo.isEmpty()) {
                    String disponivel = chkDisponivel.isSelected() ? "Sim" : "Não";
                    String[] livro = {
                            titulo,
                            txtAutor.getText().trim(),
                            txtAno.getText().trim(),
                            txtEditora.getText().trim(),
                            txtPaginas.getText().trim(),
                            txtEmprestimo.getText().trim(),
                            disponivel
                    };
                    MemoryBookList.set(row, livro);
                    for (int i = 0; i < livro.length; i++) {
                        tableModel.setValueAt(livro[i], row, i);
                    }
                    JOptionPane.showMessageDialog(frame, "Livro substituído.");
                } else if (row == -1) {
                    JOptionPane.showMessageDialog(frame, "Selecione um livro para modificá-lo.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha ao menos o título.");
                }

            } else if (box.getSelectedItem().equals("Excluir")) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    MemoryBookList.remove(row);
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(frame, "Livro excluído.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um livro para excluí-lo.");
                }

            } else if (box.getSelectedItem().equals("Pesquisar")) {
                String titulo = txtTitulo.getText().trim();
                boolean found = false;
                for (int i = 0; i < MemoryBookList.size(); i++) {
                    if (MemoryBookList.get(i)[0].equalsIgnoreCase(titulo)) {
                        table.setRowSelectionInterval(i, i);
                        JOptionPane.showMessageDialog(frame, "Livro encontrado.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame, "Não possuímos esse livro.");
                }
            }
        });

        btnVoltar.addActionListener(e -> frame.setVisible(false));

        panel.add(box);
        panel.add(confirmButton);
        panel.add(btnVoltar);

        frame.add(lblTitulo);
        frame.add(lblAutor);
        frame.add(lblAno);
        frame.add(lblEditora);
        frame.add(lblPaginas);
        frame.add(lblEmprestimo);
        frame.add(txtTitulo);
        frame.add(txtAutor);
        frame.add(txtAno);
        frame.add(txtEditora);
        frame.add(txtPaginas);
        frame.add(txtEmprestimo);
        frame.add(chkDisponivel);
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