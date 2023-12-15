package dev.knodeln.chuddy.model;
import java.time.LocalDate;
import java.util.Date;

public class CustomEvent {
    private String eventName;
    private LocalDate eventDate;

    public CustomEvent (String eventName, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void seEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate evenDate) {
        this.eventDate = evenDate;
    }

    public String toString() {
        return "Namn på event: " + eventName + "\nDatum: " + eventDate;
    }
}
