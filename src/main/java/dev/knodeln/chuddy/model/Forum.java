package dev.knodeln.chuddy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

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

    public DiscussionThread getSelectedThread(){
        return selectedThread;
    }

    public void addUser(ChuddyUser user) {
        users.add(user);
    }

    public DiscussionThread createThread(String threadName) {
        DiscussionThread newThread = new DiscussionThread(null, threadName);
        threads.add(newThread);
        selectedThread = newThread;

        return newThread; // Return the created thread
    }

    public void addMessage(String content) {
        // sender = getCurrentUser()
        ChuddyUser sender = new ChuddyUser("Senja");
        Message message = new Message(sender, content);

        if (selectedThread != null) {

            selectedThread.addMessage(message);
            System.out.println("Message added to the selected thread: " + selectedThread.getThreadName());

        } else {
            System.out.println("No thread selected. Choose a thread or create a new one:");
            selectOrCreateThread();
            selectedThread.addMessage(message);
            System.out.println("Message added to the selected thread: " + selectedThread.getThreadName());
        }
    }

    // dela upp denna metod i 2
    void selectOrCreateThread() {
        if (threads.isEmpty()) {
            String threadName = JOptionPane.showInputDialog("Enter the name of the new thread:");
            if (threadName != null && !threadName.isEmpty()) {
                selectedThread = createThread(threadName);
                System.out.println("New thread created: " + selectedThread.getThreadName());

            }
        } else {
            String threadName = JOptionPane.showInputDialog("Enter the name of the thread:");
            selectedThread = getThreadByName(threadName);
        }
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
                                .println(message.getSender() + ": " + message.getContent() + " " + message.timeStamp());
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