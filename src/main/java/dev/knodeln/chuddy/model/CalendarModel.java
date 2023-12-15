package dev.knodeln.chuddy.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CalendarModel {
    private String selectedDate;
    private Map<String, List<CustomEvent>> eventsByDate = new HashMap<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void addEvent(String selectedDate, CustomEvent event) {
        List<CustomEvent> events = eventsByDate.getOrDefault(selectedDate, new ArrayList<>());
        events.add(event);
        eventsByDate.put(selectedDate, events);
    }

    public List<CustomEvent> getEventsByDate(String selectedDate) {
        return eventsByDate.getOrDefault(selectedDate, new ArrayList<>());
    }

    public Map<String, List<CustomEvent>> getAllEvents() {
        return eventsByDate;
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

    public List<CustomEvent> getEventsForSelectedDate() {
        return eventsByDate.get(selectedDate);
    }
    
}
