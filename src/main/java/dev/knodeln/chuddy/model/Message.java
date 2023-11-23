package dev.knodeln.chuddy.model;

import java.util.Scanner;
import java.util.Random;

public class Message {
    private ChuddyUser sender;
    private String content;

    // lägg till timestamp också
    public Message(ChuddyUser sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public ChuddyUser getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    // testar först chatta med bot
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ChatBot: Hello! How can I help you today?");

        while (true) {
            String userMessage = scanner.nextLine();

            String botResponse = generateRandomResponse();
            System.out.println("ChatBot: " + botResponse);

            if (userMessage.equalsIgnoreCase("bye")) {
                System.out.println("ChatBot: Goodbye! Have a great day!");
                break;
            }
        }
        scanner.close();
    }

    private static String generateRandomResponse() {
        String[] responses = {
                "I'm not sure how to respond to that.",
                "Tell me more.",
                "Interesting!",
                "What do you think about that?",
                "I see.",
                "That's cool!",
                "I'm a chatbot, so I don't have personal opinions."
        };

        Random random = new Random();
        int index = random.nextInt(responses.length);
        return responses[index];
    }
}