package dev.knodeln.chuddy.model;
import java.util.Date;

public class Event {
    private String name;
    private Date date;
    private int interested;

    public Event(String name, Date date) {
        this.name = name;
        this.date = date;
        this.interested = 0;
    }
    public int getInterested() {
        return interested;
    }

    public void setInterested(int interested) {
        this.interested = interested;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}