package POO;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
public class Employee {
    public Employee() {
        JFrame frame = new JFrame("Alexandria do Manfrine — Registro de funcionários");
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,600,600);
        panel.setBackground(Color.LIGHT_GRAY);

        ArrayList<String> MemoryEmployeeList = new ArrayList<String>();
        DefaultListModel<String> EmployeeList = new DefaultListModel<String>();
        JList<String> list = new JList<String>(EmployeeList);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(100, 280, 300, 200);


        JTextField text = new JTextField();
        text.setEditable(true);
        text.setBounds(100, 100, 300, 30);


//HERE BEGINS THE CREATION OF THE COMBO-BOX USED TO SELECT WHICH
//OPTION IN THE REGISTRY THE USER WILL BE MAKING USE OF.

        String[] options = {"Cadastrar", "Modificar", "Excluir", "Pesquisar"};
        JComboBox box = new JComboBox(options);
        JButton confirmButton = new JButton("Confirmar");
        panel.add(box);
        panel.add(confirmButton);

        confirmButton.addActionListener(e -> {
            if(box.getSelectedItem().equals("Cadastrar")){
                String book = text.getText().trim();
                if (!book.isEmpty()) {
                    MemoryEmployeeList.add(book);
                    EmployeeList.addElement(book);
                    JOptionPane.showMessageDialog(frame, "Novo funcionário adicionado.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha com algum funcionário antes.");
                }
            }else if (box.getSelectedItem().equals("Modificar")) {
                int index = list.getSelectedIndex();
                String NewName = text.getText().trim();
                if (index != -1 && !NewName.isEmpty()) {
                    MemoryEmployeeList.set(index, NewName);
                    EmployeeList.set(index, NewName);
                    JOptionPane.showMessageDialog(frame, "Funcionário substituído.");
                } else if (index == -1) {
                    JOptionPane.showMessageDialog(frame, "Selecione um funcionário para modificá-lo.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Digite um novo nome para este funcionário.");
                }
            }else if (box.getSelectedItem().equals("Excluir")) {
                int index = list.getSelectedIndex();
                if (index != -1) {
                    MemoryEmployeeList.remove(index);
                    EmployeeList.remove(index);
                    JOptionPane.showMessageDialog(frame, "Funcionário excluido.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um funcionário para excluí-lo.");
                }
            }else if (box.getSelectedItem().equals("Pesquisar")) {
                String book = text.getText().trim();
                if (MemoryEmployeeList.contains(book)) {
                    int index = MemoryEmployeeList.indexOf(book);
                    list.setSelectedIndex(index);
                    JOptionPane.showMessageDialog(frame, "Funcionário encontrado.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Não possuimos esse funcionário.");
                }
            }
        });
        frame.add(scroll);
        frame.add(text);
        frame.add(panel);

        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
}