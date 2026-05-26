package POO;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public MainMenu() {

        JFrame mainMenu = new JFrame("Alexandria do Manfrine — Menu principal");

        // Instancia uma vez só aqui
        Book bookScreen = new Book();
        Employee employeeScreen = new Employee();
        Readers readerScreen = new Readers();

        Label introduction = new Label("Este é o menu principal da Alexandria do Manfrine." +
                " Por favor, selecione o registro desejado:");

        introduction.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JRadioButton bookButton = new JRadioButton("Registro de livros");
        bookButton.setBackground(Color.LIGHT_GRAY);
        bookButton.setFont(new Font("Comic Sans", Font.BOLD, 16));
        JRadioButton employeeButton = new JRadioButton("Registro de funcionários");
        employeeButton.setBackground(Color.LIGHT_GRAY);
        employeeButton.setFont(new Font("Comic Sans", Font.BOLD, 16));
        JRadioButton borrowerButton = new JRadioButton("Registro de leitores");
        borrowerButton.setBackground(Color.LIGHT_GRAY);
        borrowerButton.setFont(new Font("Comic Sans", Font.BOLD, 16));

        ButtonGroup group = new ButtonGroup();
        group.add(bookButton);
        group.add(employeeButton);
        group.add(borrowerButton);

        mainMenu.setLayout(new GridLayout(0, 1));
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setResizable(false);
        mainMenu.getContentPane().add(introduction, BorderLayout.CENTER);
        mainMenu.getContentPane().setBackground(Color.LIGHT_GRAY);
        mainMenu.setIconImage(new ImageIcon("images/manfrine-sorrindo.png").getImage());

        mainMenu.add(bookButton);
        mainMenu.add(employeeButton);
        mainMenu.add(borrowerButton);

        JButton confirmButton = new JButton("Confirmar");
        mainMenu.add(confirmButton);

        confirmButton.addActionListener(e -> {
            if (bookButton.isSelected()) {
                bookScreen.showFrame();
            } else if (employeeButton.isSelected()) {
                employeeScreen.showFrame();
            } else if (borrowerButton.isSelected()) {
                readerScreen.showFrame();
            } else {
                JOptionPane.showMessageDialog(mainMenu, "Selecione um registro antes de continuar.");
            }
        });

        mainMenu.pack();
        mainMenu.setVisible(true);
    }
}