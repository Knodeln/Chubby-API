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
// fixa så att timeStamp inte uppdateras när man skickar ett nytt meddelande
    public String timeStamp() {
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("dd MMMM hh:mm");
        return dateForm.format(thisDate);
    }

 /*   public static void main(String[] args) {
        ChuddyUser test1 = new ChuddyUser("Senja");
        ChuddyUser test2 = new ChuddyUser("Joel");
        Message testmessage = new Message(test2, "uiwheiahweuiehiqhweu");
    }*/
}