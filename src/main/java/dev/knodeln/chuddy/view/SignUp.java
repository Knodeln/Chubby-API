package dev.knodeln.chuddy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {
    private JFrame signUpFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;

    public SignUp() {

        signUpFrame = new JFrame("Sign Up");
        signUpFrame.setSize(300, 200);
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        signUpButton = new JButton("Sign Up");



        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Placeholder for alignment
        panel.add(signUpButton);

        signUpFrame.add(panel);
        signUpFrame.setVisible(true);
    }

    // Example signup method (replace with your actual signup logic)
    @Override
    public void actionPerformed(ActionEvent e) {
        // Perform signup functionality here
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

    }


}

