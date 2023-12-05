package dev.knodeln.chuddy.view;

import javax.swing.*;

import dev.knodeln.chuddy.model.ChuddyUser;
import dev.knodeln.chuddy.model.FakeUsers;
import dev.knodeln.chuddy.model.SimilarityCalculator;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.lang.Math;

public class displayUsers extends JFrame {

    public displayUsers(Map<ChuddyUser, Double> users) {

        setTitle("Sorted User Profiles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create a JPanel to display the sorted profiles
        JPanel panel = new JPanel(new GridLayout(users.size(), 1));

        for (Map.Entry<ChuddyUser, Double> entry : users.entrySet()) {
            JLabel profileLabel = new JLabel(entry.getKey().getName() + " " + entry.getValue() + "%");
            panel.add(profileLabel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {

        // just for testing! this is not MVC
        ChuddyUser user = FakeUsers.getUser();
        Map<ChuddyUser, Double> users = new HashMap<ChuddyUser, Double>();
        Map<ChuddyUser, Double> sortedUsers = new LinkedHashMap<>();
        List<Double> values = new ArrayList<>();

        for (ChuddyUser u : FakeUsers.getUsers()) {
            users.put(u, SimilarityCalculator.calculateMatch(user, u));
        }

        for (Double value : users.values()) {
            if (!values.contains(value))
                values.add(value);
        }

        Collections.reverse(values);

        for (double value : values) {
            for (ChuddyUser u : users.keySet()) {
                if (users.get(u) == value)
                    sortedUsers.put(u, value);
            }
        }

        SwingUtilities.invokeLater(() -> new displayUsers(sortedUsers));
    }
}
