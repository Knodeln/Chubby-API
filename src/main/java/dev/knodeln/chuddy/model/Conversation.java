package dev.knodeln.chuddy.model;

import java.util.List;

public class Conversation {

    private ChuddyUser user1;

    private ChuddyUser user2;

    private List<Message> user1Messages;

    private List<Message> user2Messages;

    public ChuddyUser getUser1() {
        return user1;
    }

    public ChuddyUser getUser2() {
        return user2;
    }

    public List<Message> getUser1Messages() {
        return user1Messages;
    }

    public List<Message> getUser2Messages() {
        return user2Messages;
    }

    public void createMessage(String text, String time, ChuddyUser user){
        if (user == user1){
            user1Messages.add(new Message(text, time));
        }
        if (user == user2){
            user2Messages.add(new Message(text, time));
        }
    }
}
