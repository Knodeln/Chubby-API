package dev.knodeln.chuddy.model;

import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Message {
    private ChuddyUser sender;
    private String content;
    private String timestamp;

    public Message(ChuddyUser sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = generateTimeStamp();
    }

    public ChuddyUser getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getTimeStamp() {
        return timestamp;
    }

    private String generateTimeStamp() {
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("[HH:mm:ss]");
        return dateForm.format(thisDate);

    }
}