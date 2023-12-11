package dev.knodeln.chuddy.view;

import dev.knodeln.chuddy.controller.CurrentUserController;
import dev.knodeln.chuddy.controller.ViewController;
import dev.knodeln.chuddy.model.ChuddyDataHandler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginGUI extends JFrame implements ActionListener{

	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
    JButton signupButton = new JButton("Sign Up");
	JTextField userMailField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userMailLabel = new JLabel("E-mail:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();

	
	public LoginGUI(){

		setLocationRelativeTo(null);
		setTitle("Login");

		
		userMailLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userMailField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);

        signupButton.setBounds(25,200,100,25);
		signupButton.setFocusable(false);
		signupButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		this.add(userMailLabel);
		this.add(userPasswordLabel);
		this.add(messageLabel);
		this.add(userMailField);
		this.add(userPasswordField);
		this.add(loginButton);
		this.add(resetButton);
		this.add(signupButton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420,420);
		this.setLayout(null);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			userMailField.setText("");
			userPasswordField.setText("");
		}

        if(e.getSource() == signupButton) {
            ViewController.setSignUpView();
			this.dispose();
        }
		
		if(e.getSource()==loginButton) {
			
			String userID = userMailField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			try {
				CurrentUserController.login(userID, password);

				this.dispose();
				ViewController.setProfilePageView();
			} catch (Exception ex) {
				System.out.println(ex);
				JOptionPane.showMessageDialog(null, "User not found");
			}


		}
	}
}