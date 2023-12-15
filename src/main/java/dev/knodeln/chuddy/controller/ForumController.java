package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.model.*;
import dev.knodeln.chuddy.view.ChatForumGUI;

import java.util.List;
import java.util.ArrayList;

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

    public static void addMessage(String message, ChuddyUser sender) {
        forum.addMessage(message, sender);
    }

    public static void initDefaultForums() {

        ForumInitializer.initializeDefaultThreads();

    }

    public static List<DiscussionThread> getUserThreads(ChuddyUser user) {
        
        return forum.getUserThreads(user);

    }

    public static String getNewThreadName() {
        return ChatForumGUI.getNameOfNewThread();
    }
}
