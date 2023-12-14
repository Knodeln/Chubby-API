package dev.knodeln.chuddy.model;

import java.util.ArrayList;
import java.util.List;

public class PrivateChat {

    private List<Conversation> conversations;

    private Conversation selectedConversation;

    public PrivateChat() {
        this.conversations = new ArrayList<>();
    }
    public void createConversation(ChuddyUser user1, ChuddyUser user2) {
        conversations.add(new Conversation(user1, user2));
    }

    public void selectConversation (ChuddyUser user1, ChuddyUser user2) {
        boolean conversationFound = false;
        for (Conversation conversation : conversations) {
            if(conversation.getUsers().contains(user1) && conversation.getUsers().contains(user2)) {
                selectedConversation = conversation;
                conversationFound = true;
                break;
            }
        }
        if(!conversationFound) {
            createConversation(user1, user2);
            selectedConversation = conversations.get(conversations.size()-1);
        }
    }
    public void addMessage(String content, ChuddyUser sender) {
        selectedConversation.addMessage(new Message(sender, content));
    }
    public List<Message> getMessages() {
        return selectedConversation.getMessages();
    }

}
