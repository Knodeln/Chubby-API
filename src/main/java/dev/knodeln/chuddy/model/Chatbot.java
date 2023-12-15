package dev.knodeln.chuddy.model;

import java.util.Random;

public class Chatbot {
    private String name;
    private Random random;
    private String[] responses;

    public Chatbot(String name, String[] responses) {
        this.random = new Random();
        this.responses = responses;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String generateResponse() {
        int index = random.nextInt(responses.length);
        return responses[index];
    }
}