package POO;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public MainMenu() {

        JFrame mainMenu = new JFrame("Alexandria do Manfrine — Menu principal");

        Label introduction = new Label("Este é o menu principal da Alexandria do Manfrine." +
                " Por favor, selecione o registro desejado:");

        JRadioButton bookButton = new JRadioButton("Registro de livros");
        JRadioButton employeeButton = new JRadioButton("Registro de Funcionários");
        JRadioButton borrowerButton = new JRadioButton("Registro de Sócio");

        ButtonGroup group = new ButtonGroup();
        group.add(bookButton);
        group.add(employeeButton);
        group.add(borrowerButton);

        mainMenu.setLayout(new FlowLayout());
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setResizable(true);
        mainMenu.getContentPane().add(introduction, BorderLayout.CENTER);

        mainMenu.setIconImage(new ImageIcon("images/manfrine-sorrindo.png").getImage());

        mainMenu.add(bookButton);
        mainMenu.add(employeeButton);
        mainMenu.add(borrowerButton);

        JButton confirmButton = new JButton("Confirmar");
        mainMenu.add(confirmButton);

        confirmButton.addActionListener(e -> {
            if(bookButton.isSelected()){
                new Book();
            } else if (employeeButton.isSelected()){
                new Librarian();
            } else if (borrowerButton.isSelected()){
                new Readers();
            } else {
                JOptionPane.showMessageDialog(mainMenu, "Selecione um registro antes de continuar.");
            }
        });

        mainMenu.pack();
        mainMenu.setVisible(true);
    }
}