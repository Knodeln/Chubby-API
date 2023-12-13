package dev.knodeln.chuddy.model;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class CalendarApp extends JFrame {
  /*  private JTextArea eventArea;

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

        ArrayList events = generateDemoEvents();
        
        //Loopar för 14 dagar
        for (int i = 0; i < 14; i++) {
            eventText.append("\n").append(dateFormat.format(calendar.getTime())).append("\n");

            ArrayList dayEvents = filterEventsByDay(calendar.getTime(), events);
            
            if (i == 0 || i == 7) {
                eventText.append("- Denna veckan \n");
            }
            else if (i == 1 || i == 8) {
                eventText.append("- Nästa vecka \n");
            }

            for (Object obj : dayEvents) {
                Event event = (Event) obj;
                eventText.append(event.getName()).append("\n");
            }
            
            calendar.add(Calendar.DATE, 1);

        }

        eventArea.setText(eventText.toString());

    }

    private ArrayList filterEventsByDay(Date date, ArrayList events) {
        ArrayList filteredEvents = new ArrayList();
        for (Object obj : events) {
            Event event = (Event) obj;
            if (isSameDay(event.getDate(), date)) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }

    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    private ArrayList generateDemoEvents() {
        ArrayList events = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            int daysToAdd = random.nextInt(365);
            calendar.add(Calendar.DATE, daysToAdd);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            Event event = new Event("Event " + (i + 1) + " on " + year + "-" + (month + 1) + "-" + day, calendar.getTime());
            events.add(event);
            calendar.setTime(new Date());
        }
        
        return events;
    }

    public static void main(String[] args) {
        SwingUtilities. invokeLater(() -> {
            CalendarApp calendarApp = new CalendarApp();
            calendarApp.setVisible(true);
        }); 
    */
    //}
    
}
