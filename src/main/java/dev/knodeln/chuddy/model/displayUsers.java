package dev.knodeln.chuddy.model;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class displayUsers extends JFrame {

    private List<UserProfile> userProfileList; //ändra detta till rätt namn
    private UserProfile specificProfile;

    public displayUsers(List<UserProfile> userProfileList, UserProfile specificProfile) {
        this.userProfileList = userProfileList;
        this.specificProfile = specificProfile;

        setTitle("Sorted User Profiles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Sort the profiles by similarity
        Map<UserProfile, Double> similarityMap = calculateSimilarity();
        List<Map.Entry<UserProfile, Double>> sortedList = sortProfilesBySimilarity(similarityMap);

        // Create a JPanel to display the sorted profiles
        JPanel panel = new JPanel(new GridLayout(sortedList.size(), 1));

        for (Map.Entry<UserProfile, Double> entry : sortedList) {
            JLabel profileLabel = new JLabel("Similarity: " + entry.getValue() + "% - " + entry.getKey().getName());
            panel.add(profileLabel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    // Calculate similarities between specific profile and other profiles
    private Map<UserProfile, Double> calculateSimilarity() {
        Map<UserProfile, Double> similarityMap = new HashMap<>();

        for (UserProfile profile : userProfileList) {
            if (!profile.equals(specificProfile)) {
                double similarity = UserProfile.calculateSimilarity(specificProfile, profile);
                similarityMap.put(profile, similarity);
            }
        }

        return similarityMap;
    }

    // Sort profiles by similarity in descending order
    private List<Map.Entry<UserProfile, Double>> sortProfilesBySimilarity(Map<UserProfile, Double> similarityMap) {
        List<Map.Entry<UserProfile, Double>> sortedList = new ArrayList<>(similarityMap.entrySet());
        sortedList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return sortedList;
    }

    public static void main(String[] args) {
        // Assuming userProfileList contains a list of user profiles
        // Assuming specificProfile is one of the profiles for comparison
        List<UserProfile> userProfileList = new ArrayList<>();
        // Add user profiles to the list

        // Assuming specificProfile is set to one of the profiles in the list

        SwingUtilities.invokeLater(() -> new displayUsers(userProfileList, specificProfile));
    }
}
