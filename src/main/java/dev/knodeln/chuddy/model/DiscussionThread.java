package dev.knodeln.chuddy.model;

import java.util.ArrayList;
import java.util.List;

public class DiscussionThread {
    private List<Message> messages;
    private String threadName;

    public DiscussionThread() {
        this.messages = new ArrayList<>();
        this.threadName = null;
    }

    public DiscussionThread(Message initialMessage, String threadName) {
        this.messages = new ArrayList<>();
        this.threadName = threadName;

        if (initialMessage != null) {
            messages.add(initialMessage);
        }
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return new ArrayList<>(messages);
    }

    public String getThreadName() {
        return threadName;
    }

    public List<Message> getMessagesCopy() {
        return new ArrayList<>(messages);
    }

    public boolean containsUser(ChuddyUser user) {
        for (Message message : messages) {
            if (message.getSender().equals(user)) {
                return true;
            }
        }
        return false;
    }
}
