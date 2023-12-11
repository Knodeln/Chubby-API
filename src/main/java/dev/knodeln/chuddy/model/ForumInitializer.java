package dev.knodeln.chuddy.model;

public class ForumInitializer {
    public static void initializeDefaultThreads(Forum forum) {
        DiscussionThread thread1 = forum.createThread("Gasquen någon?");
        DiscussionThread thread2 = forum.createThread("söker pluggkompis!!");

        ChuddyUser user1 = new ChuddyUser("Bengt");
        ChuddyUser user2 = new ChuddyUser("Sven");

        forum.getThreads().add(thread1);
        forum.getThreads().add(thread2);
        
        forum.addMessage(user1, "Tja jag hänger gärna med till gasquen!!");
        forum.addMessage(user2, "Jag med!");

        forum.addMessage(user1, "Hej! Jag söker någon att plugga med.");
        forum.addMessage(user2, "Jag är också intresserad. Vilket ämne?");


    }

}
