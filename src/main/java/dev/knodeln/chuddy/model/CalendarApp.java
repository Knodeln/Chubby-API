package dev.knodeln.chuddy.model;
import javax.swing.*;
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

        StringBuilder eventText = new StringBuilder("Events: \n");

        boolean nextWeekHeaderPrinted = false;
        eventText.append("- Denna veckan -\n");
        
        for (int i = 0; i < 14; i++) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && !nextWeekHeaderPrinted) {
                eventText.append("- Nästa vecka -\n");
                nextWeekHeaderPrinted = true;
            } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                eventText.append("- Om 2 veckor -\n");
            }

            eventText.append(dateFormat.format(calendar.getTime())).append("\n");   
            
            ArrayList<Event> events = generateRandomEvents();
            for (Event event : events) {
                    eventText.append("- ").append(event.getName()).append("\n");
            }
            
            calendar.add(Calendar.DATE, 1);

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

