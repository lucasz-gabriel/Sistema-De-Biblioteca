package POO;

import javax.swing.*;
import java.util.ArrayList;
public class Readers {
    public Readers() {
        JFrame frame = new JFrame("Cadastro de leitores");

        frame.setLayout(null);

        ArrayList<String> MemoryReaders = new ArrayList<String>();
        DefaultListModel<String> BookReaders = new DefaultListModel<String>();
        JList<String> list = new JList<String>(BookReaders);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(100, 280, 300, 200);


        JTextField text = new JTextField();
        text.setEditable(true);
        text.setBounds(100, 100, 300, 30);

        JButton button = new JButton("Cadastrar");
        button.setBounds(100, 140, 100, 60);
        button.addActionListener(e -> {
            String employeer = text.getText().trim();
            if (!employeer.isEmpty()) {
                MemoryReaders.add(employeer);
                BookReaders.addElement(employeer);
                JOptionPane.showMessageDialog(frame, "Novo leitor cadastrado!");
            } else {
                JOptionPane.showMessageDialog(frame, "Nenhum leitor cadastrado!");
            }
        });
        JButton button2 = new JButton("Modificar");
        button2.setBounds(220, 140, 100, 60);
        button2.addActionListener(e -> {
            int index = list.getSelectedIndex();
            String NewName = text.getText().trim();
            if (index != -1 && !NewName.isEmpty()) {
                MemoryReaders.set(index, NewName);
                BookReaders.set(index, NewName);
                JOptionPane.showMessageDialog(frame, "Leitor substituído!");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(frame, "Selecione um leitor para modificá-lo!");
            } else {
                JOptionPane.showMessageDialog(frame, "Qual o nome do novo leitor?");
            }
        });
        JButton button3 = new JButton("Excluir");
        button3.setBounds(100, 200, 100, 60);
        button3.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index != -1) {
                MemoryReaders.remove(index);
                BookReaders.remove(index);
                JOptionPane.showMessageDialog(frame, "Livro devolvido!");
            } else {
                JOptionPane.showMessageDialog(frame, "Selecione o leitor que devolveu o livro!");
            }
        });
        JButton button4 = new JButton("Pesquisar");
        button4.setBounds(220, 200, 100, 60);
        button4.addActionListener(e -> {
            String book = text.getText().trim();
            if (MemoryReaders.contains(book)) {
                int index = MemoryReaders.indexOf(book);
                list.setSelectedIndex(index);
                JOptionPane.showMessageDialog(frame, "Leitor encontrado!");
            } else {
                JOptionPane.showMessageDialog(frame, "Essa pessoa não tem livros alugados!");
            }
        });

        JPanel panel = new JPanel();


        frame.add(button);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        frame.add(scroll);
        frame.add(panel);
        frame.add(text);


        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}