package dev.knodeln.chuddy.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ProfilePageGUI extends JFrame {
    private JTextField nameField, ageField, edProgrammeField, yearField, genderField, profilePicField;
    private JTextArea descriptionArea, interestsArea;
    private ChuddyUser user;

    public ProfilePageGUI(ChuddyUser user) {
        this.user = user;
        setTitle("User Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(9, 2, 10, 5)); // Adjust layout as needed

        mainPanel.add(new JLabel("Name:"));
        nameField = new JTextField(user.getName());
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Age:"));
        ageField = new JTextField(user.getAge());
        mainPanel.add(ageField);

        mainPanel.add(new JLabel("Description:"));
        descriptionArea = new JTextArea(user.getUserDescription(), 4, 20);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        mainPanel.add(descriptionScrollPane);

        mainPanel.add(new JLabel("Education Programme:"));
        edProgrammeField = new JTextField(user.getEdProgramme());
        mainPanel.add(edProgrammeField);

        mainPanel.add(new JLabel("Year:"));
        yearField = new JTextField(user.getYear());
        mainPanel.add(yearField);

        mainPanel.add(new JLabel("Gender:"));
        genderField = new JTextField(user.getGender());
        mainPanel.add(genderField);

        mainPanel.add(new JLabel("Profile Picture URL:"));
        profilePicField = new JTextField(user.getProfilePicture());
        mainPanel.add(profilePicField);

        mainPanel.add(new JLabel("Interests:"));
        interestsArea = new JTextArea(String.join(", ", user.getInterests()), 2, 20);
        JScrollPane interestsScrollPane = new JScrollPane(interestsArea);
        mainPanel.add(interestsScrollPane);

        JButton saveButton = new JButton("Save Profile");
        saveButton.addActionListener(e -> saveProfile());
        mainPanel.add(saveButton);

        add(mainPanel);
        setVisible(true);
    }

    private void saveProfile() {
        // Retrieve updated information from the GUI fields and update the 'user' object
        user.setName(nameField.getText());
        user.setAge(ageField.getText());
        user.setUserDescription(descriptionArea.getText());
        user.setEdProgramme(edProgrammeField.getText());
        user.setYear(yearField.getText());
        user.setGender(genderField.getText());
        user.setProfilePicture(profilePicField.getText());

        // Split interests by comma and update the interests list in the 'user' object
        String interestsText = interestsArea.getText();
        String[] interestsArray = interestsText.split(",");
        user.setInterests(Arrays.asList(interestsArray));

        // Example: Printing the updated user information
        System.out.println("Updated User Name: " + user.getName());
        System.out.println("Updated User Age: " + user.getAge());
        // Print other updated fields in a similar manner
    }

}