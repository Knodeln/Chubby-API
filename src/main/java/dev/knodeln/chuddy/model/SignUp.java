package dev.knodeln.chuddy.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp {
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

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform signup functionality here
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                // Add code to handle signup logic using the entered username and password
                // For example: signup(username, password);
                // Remember to implement your signup logic here
                // After signup, you might want to dispose of the signup window
                if(e.getSource() == signUpButton) {
                    LoginGUI loginPage = new LoginGUI(null); 
                    loginPage.displayLoginGUI();
                    signUpFrame.dispose(); 
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Placeholder for alignment
        panel.add(signUpButton);

        signUpFrame.add(panel);
        signUpFrame.setVisible(true);
    }

    // Method to display the SignUp GUI
    public void displaySignUpGUI() {
        signUpFrame.setVisible(true);
    }

    // Example signup method (replace with your actual signup logic)
    private void signup(String username, String password) {
        // Implement your signup logic here
        // For example, adding the username and password to a database or map
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }
}

