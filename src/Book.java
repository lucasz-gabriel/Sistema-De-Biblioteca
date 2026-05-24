import javax.swing.*;
import java.util.ArrayList;
public class Book {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de livros");

        frame.setLayout(null);

        ArrayList<String> MemoryBookList = new ArrayList<String>();
        DefaultListModel<String> BookList = new DefaultListModel<String>();
        JList<String> list = new JList<String>(BookList);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(100,280,300,200);


        JTextField text = new JTextField();
        text.setEditable(true);
        text.setBounds(100, 100, 300, 30);

        JButton button = new JButton("Cadastrar");
        button.setBounds(100,140,100,60);
        button.addActionListener(e->{
            String book = text.getText().trim();
            if (!book.isEmpty()){
                MemoryBookList.add(book);
                BookList.addElement(book);
            } else{
                JOptionPane.showMessageDialog(frame, "Nada foi adicionado!");
            }
        });
        JButton button2 = new JButton("Modificar");
        button2.setBounds(220,140,100,60);
        button2.addActionListener(e -> {
            int index = list.getSelectedIndex();
            String NewName = text.getText().trim();
            if (index != -1 && !NewName.isEmpty()) {
                MemoryBookList.set(index, NewName);
                BookList.set(index, NewName);
            } else if (index == -1){
                JOptionPane.showMessageDialog(frame, "Selecione um livro para modificá-lo!");
            } else{
                JOptionPane.showMessageDialog(frame, "Digite um novo nome para este livro!");
            }
        });
        JButton button3 = new JButton("Excluir");
        button3.setBounds(100,200,100,60);
        button3.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if(index != -1 ){
                MemoryBookList.remove(index);
                BookList.remove(index);
                JOptionPane.showMessageDialog(frame,"Livro excluido!");
            } else {
                JOptionPane.showMessageDialog(frame, "Selecione um livro para excluí-lo");
            }
        });
        JButton button4 = new JButton("Pesquisar");
        button4.setBounds(220,200,100,60);

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