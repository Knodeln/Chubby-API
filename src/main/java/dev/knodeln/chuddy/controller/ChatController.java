package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.model.ChuddyDataHandler;
import dev.knodeln.chuddy.model.ChuddyUser;
import dev.knodeln.chuddy.model.Message;
import dev.knodeln.chuddy.model.PrivateChat;

import java.util.List;

public class ChatController {

    private static final PrivateChat privateChat = new PrivateChat();

    public static void addMessage(String content) {
        privateChat.addMessage(content, ChuddyDataHandler.getUserLoggedIn());
    }
    public static List<Message> getMessages() {
        return privateChat.getMessages();
    }
    public static void selectConversation(ChuddyUser user2) {
        privateChat.selectConversation(ChuddyDataHandler.getUserLoggedIn(), user2);
    }
}
