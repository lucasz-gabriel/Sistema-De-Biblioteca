package POO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.*;

public class Employee {
    private JFrame frame;

    public Employee() {
        frame = new JFrame("Alexandria do Manfrine — Registro de funcionários");
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        panel.setBackground(Color.LIGHT_GRAY);

        ArrayList<String[]> MemoryEmployeeList = new ArrayList<String[]>();

        String[] colunas = {"Nome", "Código", "Tipo Sanguíneo", "Salário", "Endereço", "Função", "Ativo"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50, 380, 780, 170);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(50, 120, 100, 20);

        JLabel lblCodigo = new JLabel("Código");
        lblCodigo.setBounds(270, 120, 100, 20);

        JLabel lblTipoSanguineo = new JLabel("Tipo Sanguíneo");
        lblTipoSanguineo.setBounds(490, 120, 120, 20);

        JLabel lblSalario = new JLabel("Salário");
        lblSalario.setBounds(630, 120, 100, 20);

        JLabel lblEndereco = new JLabel("Endereço");
        lblEndereco.setBounds(50, 200, 100, 20);

        JLabel lblFuncao = new JLabel("Função");
        lblFuncao.setBounds(270, 200, 100, 20);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(50, 140, 200, 30);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(270, 140, 200, 30);

        JTextField txtTipoSanguineo = new JTextField();
        txtTipoSanguineo.setBounds(490, 140, 120, 30);

        JTextField txtSalario = new JTextField();
        txtSalario.setBounds(630, 140, 150, 30);

        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(50, 220, 200, 30);

        JTextField txtFuncao = new JTextField();
        txtFuncao.setBounds(270, 220, 200, 30);

        JCheckBox chkAtivo = new JCheckBox("Ativo");
        chkAtivo.setBounds(490, 220, 100, 30);
        chkAtivo.setBackground(Color.LIGHT_GRAY);
        chkAtivo.setSelected(true);

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
                String codigo = txtCodigo.getText().trim();
                String tipoSanguineo = txtTipoSanguineo.getText().trim();
                String salario = txtSalario.getText().trim();
                String endereco = txtEndereco.getText().trim();
                String funcao = txtFuncao.getText().trim();
                String ativo = chkAtivo.isSelected() ? "Sim" : "Não";

                if (!nome.isEmpty()) {
                    String[] funcionario = {nome, codigo, tipoSanguineo, salario, endereco, funcao, ativo};
                    MemoryEmployeeList.add(funcionario);
                    tableModel.addRow(funcionario);
                    JOptionPane.showMessageDialog(frame, "Novo funcionário adicionado.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha ao menos o nome.");
                }

            } else if (box.getSelectedItem().equals("Modificar")) {
                int row = table.getSelectedRow();
                String nome = txtNome.getText().trim();
                if (row != -1 && !nome.isEmpty()) {
                    String ativo = chkAtivo.isSelected() ? "Sim" : "Não";
                    String[] funcionario = {
                            nome,
                            txtCodigo.getText().trim(),
                            txtTipoSanguineo.getText().trim(),
                            txtSalario.getText().trim(),
                            txtEndereco.getText().trim(),
                            txtFuncao.getText().trim(),
                            ativo
                    };
                    MemoryEmployeeList.set(row, funcionario);
                    for (int i = 0; i < funcionario.length; i++) {
                        tableModel.setValueAt(funcionario[i], row, i);
                    }
                    JOptionPane.showMessageDialog(frame, "Funcionário modificado.");
                } else if (row == -1) {
                    JOptionPane.showMessageDialog(frame, "Selecione um funcionário para modificá-lo.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha ao menos o nome.");
                }

            } else if (box.getSelectedItem().equals("Excluir")) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    MemoryEmployeeList.remove(row);
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(frame, "Funcionário excluído.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um funcionário para excluí-lo.");
                }

            } else if (box.getSelectedItem().equals("Pesquisar")) {
                String nome = txtNome.getText().trim();
                boolean found = false;
                for (int i = 0; i < MemoryEmployeeList.size(); i++) {
                    if (MemoryEmployeeList.get(i)[0].equalsIgnoreCase(nome)) {
                        table.setRowSelectionInterval(i, i);
                        JOptionPane.showMessageDialog(frame, "Funcionário encontrado.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame, "Funcionário não encontrado.");
                }
            }
        });

        btnVoltar.addActionListener(e -> frame.setVisible(false));

        panel.add(box);
        panel.add(confirmButton);
        panel.add(btnVoltar);

        frame.add(lblNome);
        frame.add(lblCodigo);
        frame.add(lblTipoSanguineo);
        frame.add(lblSalario);
        frame.add(lblEndereco);
        frame.add(lblFuncao);
        frame.add(txtNome);
        frame.add(txtCodigo);
        frame.add(txtTipoSanguineo);
        frame.add(txtSalario);
        frame.add(txtEndereco);
        frame.add(txtFuncao);
        frame.add(chkAtivo);
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