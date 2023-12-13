package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.model.DiscussionThread;
import dev.knodeln.chuddy.model.Forum;

import java.util.List;

public class ForumController {

    private static final Forum forum = new Forum();

    public static void createThread(String threadName) {
        forum.createThread(threadName);
    }

    public static List<DiscussionThread> getDiscussionThreads() {
        return forum.getThreads();
    }
    public static DiscussionThread getSelectedThread() {
        return forum.getSelectedThread();
    }
    public static void selectThread(String selectedThread) {
        forum.selectThread(selectedThread);
    }
    public static void addMessage(String message) {
        forum.addMessage(message);
    }
}