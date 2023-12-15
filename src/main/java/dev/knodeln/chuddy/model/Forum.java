package dev.knodeln.chuddy.model;

import dev.knodeln.chuddy.controller.ForumController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Forum {
    private List<Message> messages;
    private List<DiscussionThread> threads;
    private List<ChuddyUser> users;
    private Scanner scanner = new Scanner(System.in);
    private DiscussionThread selectedThread;

    public Forum() {
        this.messages = new ArrayList<>();
        this.threads = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public DiscussionThread getSelectedThread() {
        return selectedThread;
    }

    public void addUser(ChuddyUser user) {
        users.add(user);
    }

    public DiscussionThread createThread(String threadName) {
        DiscussionThread newThread = new DiscussionThread(null, threadName);
        threads.add(newThread);
        selectedThread = newThread;

        System.out.println("New thread created: " + selectedThread.getThreadName());
        System.out.println(selectedThread);

        return newThread;
    }

    public void addMessage(String content, ChuddyUser sender) {

        Message message = new Message(sender, content);

        if (selectedThread != null) {

            selectedThread.addMessage(message);
            System.out.println("Message added to the selected thread: " + selectedThread.getThreadName());

        } else {
            selectOrCreateThread();
            selectedThread.addMessage(message);
            System.out.println("Message added to the selected thread: " + selectedThread.getThreadName());
        }
    }

    void selectOrCreateThread() {

        selectedThread = createThread(ForumController.getNewThreadName());

    }

    public List<DiscussionThread> getUserThreads(ChuddyUser user) {
        List<DiscussionThread> userThreads = new ArrayList<>();

        for (DiscussionThread thread : this.getThreads()) {
            if (thread.containsUser(user)) {
                userThreads.add(thread);
            }
        }
        return userThreads;
    }

    public void displayThreads() {
        System.out.println("Threads: ");

        for (int i = 0; i < threads.size(); i++) {
            DiscussionThread thread = threads.get(i);
            System.out.println((i + 1) + ". " + thread.getThreadName());
        }
        System.out.println("Enter the number of the thread or enter a new number to create a new thread:");
    }

    public void viewThread(String threadName) {
        System.out.println("Viewing thread: " + threadName);

        boolean threadFound = false;

        for (DiscussionThread thread : threads) {
            if (thread.getThreadName().equals(threadName)) {
                threadFound = true;
                List<Message> messages = thread.getMessagesCopy();

                for (Message message : messages) {
                    if (message != null) {
                        System.out
                                .println(message.getSender() + ": " + message.getContent() + " "
                                        + message.getTimeStamp());
                    } else {
                        System.out.println("No messages found in the thread");
                    }
                }
                break;
            }
        }

        if (!threadFound) {
            System.out.println("Thread not found.");
        }
    }

    public List<DiscussionThread> getThreads() {
        return new ArrayList<>(threads);
    }

    public DiscussionThread getThreadByName(String threadName) {
        for (DiscussionThread thread : threads) {
            if (thread.getThreadName().equals(threadName)) {
                return thread;
            }
        }
        return null;
    }

    public void selectThread(String threadName) {
        selectedThread = getThreadByName(threadName);

        if (selectedThread != null) {
            System.out.println("Selected thread: " + threadName);

        } else {
            System.out.println("Thread not found!");
        }
    }
}