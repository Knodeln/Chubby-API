package dev.knodeln.chuddy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Forum {
    private Map<String, Message> messages;
    private Map<String, Thread> threads;
    private Map<String, ChuddyUser> users;

    public Forum() {
        this.messages = new HashMap<>();
        this.threads = new HashMap<>();
        this.users = new HashMap<>();
    }

    public void createThread() {
        threads.put(Message, new Thread());
    }

}
