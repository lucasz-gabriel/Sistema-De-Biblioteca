package POO;

import javax.swing.*;
import java.util.ArrayList;
public class Librarian {
    public Librarian(){
        JFrame frame = new JFrame("Cadastro de funcionários");

        frame.setLayout(null);

        ArrayList<String> MemoryEmployees = new ArrayList<String>();
        DefaultListModel<String> Employees = new DefaultListModel<String>();
        JList<String> list = new JList<String>(Employees);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(100,280,300,200);


        JTextField text = new JTextField();
        text.setEditable(true);
        text.setBounds(100, 100, 300, 30);

        JButton button = new JButton("Cadastrar");
        button.setBounds(100,140,100,60);
        button.addActionListener(e->{
            String employeer = text.getText().trim();
            if (!employeer.isEmpty()){
                MemoryEmployees.add(employeer);
                Employees.addElement(employeer);
                JOptionPane.showMessageDialog(frame,"Novo funcionário cadastrado!");
            } else{
                JOptionPane.showMessageDialog(frame, "Nenhum funcionário cadastrado!");
            }
        });
        JButton button2 = new JButton("Modificar");
        button2.setBounds(220,140,100,60);
        button2.addActionListener(e -> {
            int index = list.getSelectedIndex();
            String NewName = text.getText().trim();
            if (index != -1 && !NewName.isEmpty()) {
                MemoryEmployees.set(index, NewName);
                Employees.set(index, NewName);
                JOptionPane.showMessageDialog(frame,"Funcionário substituído!");
            } else if (index == -1){
                JOptionPane.showMessageDialog(frame, "Selecione um funcionário para modificá-lo!");
            } else{
                JOptionPane.showMessageDialog(frame, "Qual o nome do novo funcionário?");
            }
        });
        JButton button3 = new JButton("Excluir");
        button3.setBounds(100,200,100,60);
        button3.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if(index != -1 ){
                MemoryEmployees.remove(index);
                Employees.remove(index);
                JOptionPane.showMessageDialog(frame,"Funcionário desligado");
            } else {
                JOptionPane.showMessageDialog(frame, "Selecione um funcionário para desligá-lo");
            }
        });
        JButton button4 = new JButton("Pesquisar");
        button4.setBounds(220,200,100,60);
        button4.addActionListener(e -> {
            String book = text.getText().trim();
            if (MemoryEmployees.contains(book)){
                int index = MemoryEmployees.indexOf(book);
                list.setSelectedIndex(index);
                JOptionPane.showMessageDialog(frame,"Funcionário encontrado!");
            } else {
                JOptionPane.showMessageDialog(frame,"Essa pessoa não trabalha aqui!");
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