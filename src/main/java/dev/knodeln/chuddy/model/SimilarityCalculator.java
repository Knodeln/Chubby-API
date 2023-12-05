package dev.knodeln.chuddy.model;

import java.util.*;
import java.lang.Math;

public class SimilarityCalculator {

    /*
     * calculateMatch(ChuddyUser, ChuddyUser) -> double.
     * Takes two user profiles and calculates the odds of u2 being a good match for
     * u1.
     * From 0-1, interpreted as % with 1 being 100% (perfect) match.
     */
    public static double calculateMatch(ChuddyUser u1, ChuddyUser u2) {

        // generate a score and return score/maxscore

        final double MAXSCORE = 4;
        double score = 0;

        score += getAgeScore(u1, u2);
        score += getProgrammeScore(u1, u2);
        score += getYearScore(u1, u2);
        score += getInterestScore(u1, u2);

        return score / MAXSCORE;
    }

    private static double getAgeScore(ChuddyUser u1, ChuddyUser u2) {
        List<Integer> ages = u1.getPrefAges();
        if (ages.isEmpty() ||
                ages == null ||
                ages.contains(u2.getYear()))
            return 1;

        return 0;
    }

    private static double getProgrammeScore(ChuddyUser u1, ChuddyUser u2) {
        List<Programme> programmes = u1.getPrefProgrammes();
        if (programmes == null ||
                programmes.isEmpty() ||
                programmes.contains(u2.getProgramme()))
            return 1;

        return 0;
    }

    private static double getYearScore(ChuddyUser u1, ChuddyUser u2) {
        List<Integer> years = u1.getPrefYears();
        if (years.isEmpty() ||
                years == null ||
                years.contains(u2.getYear()))
            return 1;

        return 0;
    }

    private static double getInterestScore(ChuddyUser u1, ChuddyUser u2) {
        List<Interest> interests = u1.getInterests();
        if (interests.isEmpty() ||
                interests == null)
            return 1;

        double score = 0;
        for (Interest interest : interests) {
            if (u2.getInterests().contains(interest))
                score += 1;
        }

        return score / interests.size();
    }

}
