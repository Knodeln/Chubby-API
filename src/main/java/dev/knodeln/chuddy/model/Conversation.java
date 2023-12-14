package dev.knodeln.chuddy.model;

import java.util.ArrayList;
import java.util.List;

public class Conversation {

    private List<ChuddyUser> users;

    private List<Message> messages;

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Conversation(ChuddyUser user1, ChuddyUser user2) {
        this.users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        messages = new ArrayList<>();
    }

    public List<ChuddyUser> getUsers() {
        return users;
    }
    public List<Message> getMessages() {
        return messages;
    }
}
