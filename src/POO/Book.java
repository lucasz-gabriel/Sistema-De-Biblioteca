package POO;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
public class Book {
    public Book() {
        JFrame frame = new JFrame("Alexandria do Manfrine — Registro de livros");
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,600,600);
        panel.setBackground(Color.LIGHT_GRAY);

        ArrayList<String> MemoryBookList = new ArrayList<String>();
        DefaultListModel<String> BookList = new DefaultListModel<String>();
        JList<String> list = new JList<String>(BookList);
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
                    MemoryBookList.add(book);
                    BookList.addElement(book);
                    JOptionPane.showMessageDialog(frame, "Novo livro adicionado.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha com algum livro antes.");
                }
            }else if (box.getSelectedItem().equals("Modificar")) {
                int index = list.getSelectedIndex();
                String NewName = text.getText().trim();
                if (index != -1 && !NewName.isEmpty()) {
                    MemoryBookList.set(index, NewName);
                    BookList.set(index, NewName);
                    JOptionPane.showMessageDialog(frame, "Livro substituído.");
                } else if (index == -1) {
                    JOptionPane.showMessageDialog(frame, "Selecione um livro para modificá-lo.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Digite um novo nome para este livro.");
                }
            }else if (box.getSelectedItem().equals("Excluir")) {
                int index = list.getSelectedIndex();
                if (index != -1) {
                    MemoryBookList.remove(index);
                    BookList.remove(index);
                    JOptionPane.showMessageDialog(frame, "Livro excluido.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um livro para excluí-lo.");
                }
            }else if (box.getSelectedItem().equals("Pesquisar")) {
                String book = text.getText().trim();
                if (MemoryBookList.contains(book)) {
                    int index = MemoryBookList.indexOf(book);
                    list.setSelectedIndex(index);
                    JOptionPane.showMessageDialog(frame, "Livro encontrado.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Não possuimos esse livro.");
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