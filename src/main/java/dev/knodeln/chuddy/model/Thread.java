package dev.knodeln.chuddy.model;

import java.util.ArrayList;
import java.util.List;

public class Thread {
    private String title;
    private List<Message> messages;

    public ChatThread() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }
}
