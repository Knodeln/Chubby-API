package dev.knodeln.chuddy.model;

import dev.knodeln.chuddy.controller.ForumController;

public class ForumInitializer {

    public static void initializeDefaultThreads() {
        ForumController.createThread("söker pluggkompis!!");
        ForumController.createThread("Gasquen någon?");


        ChuddyUser user1 = new ChuddyUser("Bengt");
        ChuddyUser user2 = new ChuddyUser("Sven");



        ForumController.addMessage( "Tja jag hänger gärna med till gasquen!!", user1);

        ForumController.addMessage("Jag med!", user2);

        ForumController.selectThread("söker pluggkompis!!");

        ForumController.addMessage("Hej! Jag söker någon att plugga med.", user1);
        ForumController.addMessage("Jag är också intresserad. Vilket ämne?", user2);

    }

}
