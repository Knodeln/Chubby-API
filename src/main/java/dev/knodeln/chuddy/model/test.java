package dev.knodeln.chuddy.model;

import java.util.Scanner;

//testar chatta med bot
public class test {
    public static void main(String[] args) {
        String[] botResponses = {
                "I'm not sure how to respond to that.",
                "Tell me more.",
                "Interesting!",
                "What do you think about that?",
                "I see.",
                "That's cool!",
                "I'm a chatbot, so I don't have personal opinions."
        };

        Chatbot botAlice = new Chatbot("Alice", botResponses);
        Chatbot botBob = new Chatbot("Bob", botResponses);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Chatbot: Welcome! How can I help you today?");

        while (true) {
            System.out.print("Enter bot name (Alice/Bob) or 'exit' to quit: ");
            String botName = scanner.nextLine();

            if (botName.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            }

            Chatbot currentBot = (botName.equalsIgnoreCase("Alice")) ? botAlice : botBob;

            System.out.print("User: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println(currentBot.getName() + ": Goodbye! Have a great day!");
                break;
            }

            String botResponse = currentBot.generateResponse();
            System.out.println(currentBot.getName() + ": " + botResponse);
        }

        scanner.close();
    }
}