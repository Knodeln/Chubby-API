package dev.knodeln.chuddy.view;

import dev.knodeln.chuddy.model.ChuddyDataHandler;
import dev.knodeln.chuddy.model.ChuddyUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ProfilePageGUI extends JFrame {
    private JTextField nameField, ageField, edProgrammeField, yearField, genderField, profilePicField;
    private JTextArea descriptionArea, interestsArea;

    public ProfilePageGUI() {

        JFrame frame = new JFrame();
        setTitle("User Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(9, 2, 10, 5)); // Adjust layout as needed

        mainPanel.add(new JLabel("Name:"));
        nameField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getName());
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Age:"));
        ageField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getAge());
        mainPanel.add(ageField);

        mainPanel.add(new JLabel("Description:"));
        descriptionArea = new JTextArea(ChuddyDataHandler.getUserLoggedIn().getUserDescription(), 4, 20);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        mainPanel.add(descriptionScrollPane);

        mainPanel.add(new JLabel("Education Programme:"));
        edProgrammeField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getEdProgramme());
        mainPanel.add(edProgrammeField);

        mainPanel.add(new JLabel("Year:"));
        yearField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getYear());
        mainPanel.add(yearField);

        mainPanel.add(new JLabel("Gender:"));
        genderField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getGender());
        mainPanel.add(genderField);

        mainPanel.add(new JLabel("Profile Picture URL:"));
        profilePicField = new JTextField(ChuddyDataHandler.getUserLoggedIn().getProfilePicture());
        mainPanel.add(profilePicField);

        mainPanel.add(new JLabel("Interests:"));
        interestsArea = new JTextArea(String.join(", ", ChuddyDataHandler.getUserLoggedIn().getInterests()), 2, 20);
        JScrollPane interestsScrollPane = new JScrollPane(interestsArea);
        mainPanel.add(interestsScrollPane);

        JButton saveButton = new JButton("Save Profile");
        saveButton.addActionListener(e -> saveProfile());
        mainPanel.add(saveButton);

        frame.add(mainPanel);

    }

    private void saveProfile() {
        // Retrieve updated information from the GUI fields and update the 'user' object
        ChuddyDataHandler.getUserLoggedIn().setName(nameField.getText());
        ChuddyDataHandler.getUserLoggedIn().setAge(ageField.getText());
        ChuddyDataHandler.getUserLoggedIn().setUserDescription(descriptionArea.getText());
        ChuddyDataHandler.getUserLoggedIn().setEdProgramme(edProgrammeField.getText());
        ChuddyDataHandler.getUserLoggedIn().setYear(yearField.getText());
        ChuddyDataHandler.getUserLoggedIn().setGender(genderField.getText());
        ChuddyDataHandler.getUserLoggedIn().setProfilePicture(profilePicField.getText());

        // Split interests by comma and update the interests list in the 'user' object
        String interestsText = interestsArea.getText();
        String[] interestsArray = interestsText.split(",");
        ChuddyDataHandler.getUserLoggedIn().setInterests(Arrays.asList(interestsArray));

        // Example: Printing the updated user information
        System.out.println("Updated User Name: " + ChuddyDataHandler.getUserLoggedIn().getName());
        System.out.println("Updated User Age: " + ChuddyDataHandler.getUserLoggedIn().getAge());
        // Print other updated fields in a similar manner
    }

}