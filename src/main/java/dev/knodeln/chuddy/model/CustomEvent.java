package dev.knodeln.chuddy.model;
import java.util.Date;

public class CustomEvent {
    private String eventName;
    private Date eventDate;

    public CustomEvent (String eventName, Date eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void seEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date evenDate) {
        this.eventDate = evenDate;
    }

    public String toString() {
        return "Namn på event: " + eventName + "\nDatum: " + eventDate;
    }
}
