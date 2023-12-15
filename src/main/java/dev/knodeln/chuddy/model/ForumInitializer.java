package dev.knodeln.chuddy.model;

import dev.knodeln.chuddy.controller.ForumController;

public class ForumInitializer {

    public static void initializeDefaultThreads() {
        ForumController.createThread("söker pluggkompis!!");
        ForumController.createThread("Gasquen någon?");


        ChuddyUser user1 = new ChuddyUser("Sven", "test", "test", "test", "IT", "2022", "test");
        ChuddyUser user2 = new ChuddyUser("Bengt", "test", "test", "test", "Data", "2022", "test");



        ForumController.addMessage( "Tja jag hänger gärna med till gasquen!!", user1);

        ForumController.addMessage("Jag med!", user2);

        ForumController.selectThread("söker pluggkompis!!");

        ForumController.addMessage("Hej! Jag söker någon att plugga med.", user1);
        ForumController.addMessage("Jag är också intresserad. Vilket ämne?", user2);
        ForumController.selectThread(null);

        ForumController.selectThread(null);

    }

}
