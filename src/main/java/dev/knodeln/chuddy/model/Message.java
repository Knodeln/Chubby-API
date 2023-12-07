package dev.knodeln.chuddy.model;

import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Message {
    private ChuddyUser sender;
    private String content;

    public Message(ChuddyUser sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public ChuddyUser getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public static String timeStamp() {
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("dd MMMM hh:mm");
        return dateForm.format(thisDate);
    }

    public void answerMessage() {
        Thread thread = new Thread();
    }

    public static void main(String[] args) {
        ChuddyUser bajskorv = new ChuddyUser("Senja");
        ChuddyUser fitta = new ChuddyUser("Joel");
        Message testmessage = new Message(bajskorv, "uiwheiahweuiehiqhweu");
    }
}