package POO;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
public class Readers {
    public Readers() {
        JFrame frame = new JFrame("Alexandria do Manfrine — Registro de funcionários");
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,600,600);
        panel.setBackground(Color.LIGHT_GRAY);

        ArrayList<String> MemoryReaderList = new ArrayList<String>();
        DefaultListModel<String> ReaderList = new DefaultListModel<String>();
        JList<String> list = new JList<String>(ReaderList);
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
                    MemoryReaderList.add(book);
                    ReaderList.addElement(book);
                    JOptionPane.showMessageDialog(frame, "Novo leitor adicionado.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha com algum leitor antes.");
                }
            }else if (box.getSelectedItem().equals("Modificar")) {
                int index = list.getSelectedIndex();
                String NewName = text.getText().trim();
                if (index != -1 && !NewName.isEmpty()) {
                    MemoryReaderList.set(index, NewName);
                    ReaderList.set(index, NewName);
                    JOptionPane.showMessageDialog(frame, "Leitor substituído!");
                } else if (index == -1) {
                    JOptionPane.showMessageDialog(frame, "Selecione um leitor para modificá-lo.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Digite um novo nome para este leitor.");
                }
            }else if (box.getSelectedItem().equals("Excluir")) {
                int index = list.getSelectedIndex();
                if (index != -1) {
                    MemoryReaderList.remove(index);
                    ReaderList.remove(index);
                    JOptionPane.showMessageDialog(frame, "Leitor excluido!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um leitor para excluí-lo.");
                }
            }else if (box.getSelectedItem().equals("Pesquisar")) {
                String book = text.getText().trim();
                if (MemoryReaderList.contains(book)) {
                    int index = MemoryReaderList.indexOf(book);
                    list.setSelectedIndex(index);
                    JOptionPane.showMessageDialog(frame, "Leitor encontrado!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Não possuimos esse leitor.");
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