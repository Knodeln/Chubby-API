package dev.knodeln.chuddy.controller;

public class ForumController {



    public DiscussionThread createThread(String threadName) {
        DiscussionThread newThread = new DiscussionThread(null, threadName);
        threads.add(newThread);
        selectedThread = newThread;
        
        System.out.println("New thread created: " + selectedThread.getThreadName());
        System.out.println(selectedThread);

        return newThread; // Return the created thread
    }
}
