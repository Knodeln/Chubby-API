package dev.knodeln.chuddy.view;

import dev.knodeln.chuddy.Exceptions.UserAlreadyExistsException;
import dev.knodeln.chuddy.controller.ChuddyUserController;
import dev.knodeln.chuddy.controller.ViewController;
import dev.knodeln.chuddy.model.ChuddyUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {

    private JTextField usernameField;

    private JTextField ageField;
    private JTextField emailField;

    private JTextField edProgrammeField;
    private JTextField yearField;
    private JTextField genderField;
    private JPasswordField passwordField;
    private JButton signUpButton, loginButton;

    public SignUp() {

        setTitle("Signup");
        setLocationRelativeTo(null);

        this.setSize(300, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel yearLabel = new JLabel("Year:");
        JLabel edProgrammeLabel = new JLabel("EdProgramme:");
        JLabel genderLabel = new JLabel("Gender");
        usernameField = new JTextField(15);
        emailField = new JTextField(15);
        passwordField = new JPasswordField(15);
        ageField = new JTextField(15);
        genderField = new JTextField(15);
        edProgrammeField = new JTextField(15);
        yearField = new JTextField(15);
        signUpButton = new JButton("Sign Up");
        loginButton = new JButton("Login");



        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(edProgrammeLabel);
        panel.add(edProgrammeField);
        panel.add(yearLabel);
        panel.add(yearField);
        panel.add(genderLabel);
        panel.add(genderField);

        panel.add(signUpButton);
        panel.add(loginButton);
        signUpButton.addActionListener(this);
        loginButton.addActionListener(this);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String email = String.valueOf(emailField.getText());
        String age = String.valueOf(ageField.getText());
        String year = String.valueOf(yearField.getText());
        String edProgramme = String.valueOf(edProgrammeField.getText());
        String gender = String.valueOf(genderField.getText());


        if (e.getSource() == signUpButton) {

            try {
                ChuddyUserController.addUser(new ChuddyUser(username, age, email, password, edProgramme, year, gender));
                ViewController.setLoginView();
                this.dispose();
            }
            catch (UserAlreadyExistsException ex) {
                JOptionPane.showMessageDialog(null, "User already exists");
                System.out.println(ex);

            }
        }
        if (e.getSource() == loginButton) {
            ViewController.setLoginView();
            this.dispose();
        }

    }


}

