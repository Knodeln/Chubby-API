package dev.knodeln.chuddy.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomEvent {
    private String eventName;
    private LocalDate eventDate;

    private List<ChuddyUser> interested;

    public CustomEvent (String eventName, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.interested = new ArrayList<>();
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

    public List<ChuddyUser> getInterested() {
        return interested;
    }
    public void addInterestedUser(ChuddyUser user) {
        if (!interested.contains(user)) {
            interested.add(user);
        }
        else interested.remove(user);
    }
    public int getInterestedAmount() {
        return interested.size();
    }
}
