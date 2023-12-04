package dev.knodeln.chuddy.model;
import javax.swing.*;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.*;


public class CalendarApp extends JFrame {
    private JTextArea eventArea;

    public CalendarApp() {
        super("Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);  
        setLocationRelativeTo(null);

        eventArea = new JTextArea();
        eventArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(eventArea);
        getContentPane().add(scrollPane);

        displayEvents();
    }

    private void displayEvents() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);

        StringBuilder eventText = new StringBuilder("Events: \n");

        JButton createEventButton = new JButton("Skapa Event");
        createEventButton.addActionListener(e -> createCustomEvent());
        getContentPane().add(createEventButton, BorderLayout.SOUTH);

        // boolean nextWeekHeaderPrinted = false;
        // eventText.append("- Denna veckan -\n");
        
        // for (int i = 0; i < 14; i++) {
        //     if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && !nextWeekHeaderPrinted) {
        //         eventText.append("- Nästa vecka -\n");
        //         nextWeekHeaderPrinted = true;
        //     } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
        //         eventText.append("- Om 2 veckor -\n");
        //     }

        //     eventText.append(dateFormat.format(calendar.getTime())).append("\n");   
            
        //     ArrayList<Event> events = generateRandomEvents();
        //     for (Event event : events) {
        //             eventText.append("- ").append(event.getName()).append("\n");
        //     }
            
        //     calendar.add(Calendar.DATE, 1);

        // }
        
        while (calendar.get(Calendar.WEEK_OF_YEAR) <= currentWeek + 1) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                if (calendar.get(Calendar.WEEK_OF_YEAR) == currentWeek + 1) {
                    eventText.append("\n - Nästa vecka -\n");
                } else {
                    eventText.append("- Denna veckan -\n");
                }
            }
    
            eventText.append(dateFormat.format(calendar.getTime())).append("\n");
            
            // Här kan du filtrera dina händelser efter det aktuella datumet
            ArrayList<Event> events = generateRandomEvents();
            for (Event event : events) {
                eventText.append("- ").append(event.getName()).append("\n");
            }
            
            calendar.add(Calendar.DATE, 1); // Gå till nästa dag
        }
        eventArea.setText(eventText.toString());

    }

    private void createCustomEvent() {
        String eventName = JOptionPane.showInputDialog("Ange namnet på ditt event:");
        if (eventName != null && !eventName.isEmpty()) {
            Date currentDate = new Date();
            Event customEvent = new Event(eventName, currentDate);

            ArrayList<Event> events = generateRandomEvents();
            events.add(customEvent);
            updateEventDisplay(events);
        } else {
            JOptionPane.showMessageDialog(null, "Felaktigt namn på event.");
        }
    }

    private void updateEventDisplay(ArrayList<Event> events) {
        StringBuilder eventText = new StringBuilder("Events: \n");

        for (Event event : events) {
            eventText.append("- ").append(event.getName()).append("\n");
        }

        eventArea.setText(eventText.toString());
    }

    private ArrayList<Event> generateRandomEvents() {
        ArrayList<Event> events = new ArrayList<>();
        Random random = new Random();

        int numEvents = random.nextInt(5);

        for (int i = 0; i < numEvents; i++) {
            Calendar randomCalendar = Calendar.getInstance();
            randomCalendar.add(Calendar.DATE, random.nextInt(30));

            Event event = new Event("Random Event " + (i + 1), randomCalendar.getTime());
            events.add(event);
        }
        return events;
    }

    public static void main(String[] args) {
        SwingUtilities. invokeLater(() -> {
            CalendarApp calendarApp = new CalendarApp();
            calendarApp.setVisible(true);
        }); 
    }
}

