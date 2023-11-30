package dev.knodeln.chuddy.model;

import java.util.*;


    // Method to calculate similarity percentage between two profiles
public static double calculateSimilarityInterests(UserProfile profile1, UserProfile profile2) {
    int commonAttributes = 0;
    int totalAttributes = 3; // Assuming 8 common attributes

    if (profile1.getInterests() != null && profile1.getInterests().equals(profile2.getInterests()))
            commonAttributes++;

    if (profile1.getEdProgramme() != null && profile1.getEdProgramme().equals(profile2.getEdProgramme()))
            commonAttributes++;

    if (profile1.getYear() != null && profile1.getYear().equals(profile2.getYear()))
            commonAttributes++;

        // Repeat this process for other attributes...

    return ((double) commonAttributes / totalAttributes) * 100.0;
}

public static void main(String[] args) {
        // Assuming userProfileList contains a list of user profiles
    List<UserProfile> userProfileList = new ArrayList<>();
        // Add user profiles to the list

        // Comparing a specific profile with others and calculating similarity
    UserProfile specificProfile = userProfileList.get(0); // Assuming we're comparing with the first profile

    Map<UserProfile, Double> similarityMap = new HashMap<>();

    for (UserProfile profile : userProfileList) {
        if (!profile.equals(specificProfile)) {
            double similarity = calculateSimilarity(specificProfile, profile);
            similarityMap.put(profile, similarity);
        }
    }

       // Override equals and hashCode methods for proper comparison in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfile)) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

        // Sort the profiles by similarity (highest to lowest)
    List<Map.Entry<UserProfile, Double>> sortedList = new ArrayList<>(similarityMap.entrySet());
    sortedList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // Display sorted profiles
    for (Map.Entry<UserProfile, Double> entry : sortedList) {
        System.out.println("Similarity: " + entry.getValue() + "% - " + entry.getKey().getInterests());
        }
    }   
}

