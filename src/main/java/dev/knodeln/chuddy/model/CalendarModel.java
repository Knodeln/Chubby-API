package dev.knodeln.chuddy.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CalendarModel {
    private String selectedDate;
    private final Map<LocalDate, List<CustomEvent>> eventsByDate = new HashMap<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void addEvent(CustomEvent event) {
        try {
            eventsByDate.get(event.getEventDate()).add(event);
        }
        catch (Exception e) {
            eventsByDate.put(event.getEventDate(), new ArrayList<>());
            eventsByDate.get(event.getEventDate()).add(event);
        }
    }

    public List<CustomEvent> getEventsByDate(String selectedDate) {
        return eventsByDate.getOrDefault(selectedDate, new ArrayList<>());
    }

    public void removeEvent(Date date, CustomEvent event) {
        List<CustomEvent> events = eventsByDate.get(date);
        if(events != null) {
            events.remove(event);
        }
    }

    public void clearAllEvents() {
        eventsByDate.clear();
    }

    public void setSelectedDate(String date) {
        this.selectedDate = date;
    }

    public List<CustomEvent> getEventsForDate(LocalDate date) {
        return eventsByDate.get(date);
    }
    
}
