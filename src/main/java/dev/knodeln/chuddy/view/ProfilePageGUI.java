package dev.knodeln.chuddy.view;

import dev.knodeln.chuddy.controller.CurrentUserController;
import dev.knodeln.chuddy.controller.ViewController;
import dev.knodeln.chuddy.model.ChuddyDataHandler;
import dev.knodeln.chuddy.model.ChuddyUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ProfilePageGUI extends JFrame implements ActionListener {
    JTextField nameField, ageField, edProgrammeField, yearField, genderField, profilePicField;
    JTextArea descriptionArea, interestsArea;
    JButton logoutButton, forumButton, saveButton, eventCalenderButton;

    JPanel buttonPanel1, buttonPanel2;

    public ProfilePageGUI() {

        setTitle("User Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);

        this.setLayout(new GridLayout(9, 3, 10, 5)); // Adjust layout as needed

        this.add(new JLabel("Name:"));
        nameField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getName());
        this.add(nameField);

        this.add(new JLabel("Age:"));
        ageField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getAge());
        this.add(ageField);

        this.add(new JLabel("Description:"));
        descriptionArea = new JTextArea(ChuddyDataHandler.getUserLoggedIn().getUserDescription(), 4, 20);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        this.add(descriptionScrollPane);

        this.add(new JLabel("Education Programme:"));
        edProgrammeField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getEdProgramme());
        this.add(edProgrammeField);

        this.add(new JLabel("Year:"));
        yearField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getYear());
        this.add(yearField);

        this.add(new JLabel("Gender:"));
        genderField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getGender());
        this.add(genderField);

        this.add(new JLabel("Profile Picture URL:"));
        profilePicField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getProfilePicture());
        this.add(profilePicField);

        this.add(new JLabel("Interests:"));
        if(ChuddyDataHandler.getUserLoggedIn().getInterests() != null) {
            interestsArea = new JTextArea(String.join(", ", ChuddyDataHandler.getUserLoggedIn().getInterests()), 2, 20);
        }
        JScrollPane interestsScrollPane = new JScrollPane(interestsArea);
        this.add(interestsScrollPane);

        buttonPanel1 = new JPanel();
        buttonPanel2 = new JPanel();

        saveButton = new JButton("Save Profile");
        buttonPanel1.add(saveButton);
        saveButton.addActionListener(this);

        logoutButton = new JButton("Logout");
        buttonPanel1.add(logoutButton);
        logoutButton.addActionListener(this);

        forumButton = new JButton("Forum");
        buttonPanel2.add(forumButton);
        forumButton.addActionListener(this);

        eventCalenderButton = new JButton("Event Calender");
        buttonPanel2.add(eventCalenderButton);
        eventCalenderButton.addActionListener(this);

        this.add(buttonPanel1);
        this.add(buttonPanel2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String name = String.valueOf(nameField.getText());
        String age = String.valueOf(ageField.getText());
        String year = String.valueOf(yearField.getText());
        String edProgramme = String.valueOf(edProgrammeField.getText());
        String gender = String.valueOf(genderField.getText());
        String descripton = String.valueOf(descriptionArea.getText());
        String profilePicture = String.valueOf(profilePicField.getText());

        if(e.getSource()==saveButton) {
            CurrentUserController.updateCurrentUserInformation(name, age, descripton, edProgramme, year, gender, profilePicture);
            JOptionPane.showMessageDialog(null, "Profile saved");

        }
        if(e.getSource()==logoutButton) {
            CurrentUserController.logout();
            ViewController.setLoginView();
            this.dispose();
        }

    }
}