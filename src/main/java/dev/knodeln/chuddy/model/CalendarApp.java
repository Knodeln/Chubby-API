// package dev.knodeln.chuddy.model;
// import javax.swing.*;
// import java.awt.BorderLayout;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;


// public class CalendarApp extends JFrame implements DatePicker.DateSelectedListener {
//     private JTextArea eventArea;
//     private Map<Date, ArrayList<Event>> eventsByDate = new HashMap<>();
//     private DatePicker datePicker;

//     public CalendarApp() {
//         super("Event");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(300, 500);  
//         setLocationRelativeTo(null);

//         eventArea = new JTextArea();
//         eventArea.setEditable(false);

//         JScrollPane scrollPane = new JScrollPane(eventArea);
//         getContentPane().add(scrollPane);

//         datePicker = new DatePicker();
//         datePicker.addDateSelectedListener(this);
//         datePicker.setVisible(false);

//         JButton createEventButton = new JButton("Skapa event");
//         createEventButton.addActionListener(this::createEventButtonActionPerformed);
//         getContentPane().add(createEventButton, BorderLayout.SOUTH);

//         displayEvents();
//     }

//     private void displayEvents() {
//         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//         Calendar calendar = Calendar.getInstance();
//         calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
//         int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);

//         StringBuilder eventText = new StringBuilder("Events: \n");
        
//         while (calendar.get(Calendar.WEEK_OF_YEAR) <= currentWeek + 1) {
//             if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
//                 if (calendar.get(Calendar.WEEK_OF_YEAR) == currentWeek + 1) {
//                     eventText.append("\n - Nästa vecka -\n");
//                 } else {
//                     eventText.append("- Denna veckan -\n");
//                 }
//             }
    
//             eventText.append(dateFormat.format(calendar.getTime())).append("\n");
            
//             // Här kan du filtrera dina händelser efter det aktuella datumet
//             ArrayList<Event> events = generateRandomEvents();
//             for (Event event : events) {
//                 eventText.append("- ").append(event.getName()).append("\n");
//             }
            
//             calendar.add(Calendar.DATE, 1); // Gå till nästa dag
//         }
//         eventArea.setText(eventText.toString());

//     }

//     @Override
//     public void onDateSelected(String selectedDate) {
//         System.out.println("Selected Date: " + selectedDate);
//         createCustomEvent(selectedDate);
//     }

//     private void createEventButtonActionPerformed(ActionEvent evt) {
//         datePicker.setVisible(true);

//         datePicker.addDateSelectedListener(selectedDate -> {
//             JOptionPane.showMessageDialog(null, "Valt datum: " + selectedDate);

//             createCustomEvent(selectedDate);
//         });

//     }

//     private ArrayList<Event> generateRandomEvents() {
//         ArrayList<Event> events = new ArrayList<>();
//         Random random = new Random();
//         int numEvents = random.nextInt(5);

//         for (int i = 0; i < numEvents; i++) {
//             Calendar randomCalendar = Calendar.getInstance();
//             randomCalendar.add(Calendar.DATE, random.nextInt(30));

//             Event event = new Event("Random Event " + (i + 1), randomCalendar.getTime());
//             events.add(event);
//         }
//         return events;
//     }

//     private void createCustomEvent(String selectedDate) {

//         System.out.println("Selected Date (Before Parsing): " + selectedDate);
//         String eventName = JOptionPane.showInputDialog("Ange namnet på ditt event:");
//         if (eventName != null && !eventName.isEmpty()) {
//             Date currentDate = new Date();
//             SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
//             Date date = null;
//             try{
//                 date = dateFormat.parse(selectedDate);
//             } catch (ParseException e) {
//                 e.printStackTrace();
//             }

//             if (date != null) {
//                 ArrayList<Event> events = eventsByDate.getOrDefault(date, new ArrayList<>());

//                 events.add(new Event(eventName, currentDate));

//                 eventsByDate.put(date, events);

//                 updateEventDisplay();
//                 datePicker.setVisible(false);
//             } else {
//                 JOptionPane.showMessageDialog(null, "Invalid format.");
//             }
//         }
//     }
//     private void updateEventDisplay() {
//         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//         StringBuilder eventText = new StringBuilder("Events \n");

//         for(Map.Entry<Date, ArrayList<Event>> entry : eventsByDate.entrySet()) {
//             Date date = entry.getKey();
//             eventText.append("Date: ").append(dateFormat.format(date)).append("\n");

//             ArrayList<Event> events = entry.getValue();
//             for (Event event : events) {
//                 eventText.append("- ").append(event.getName()).append("\n");
//             }

//             eventText.append("\n");
//         }

//         eventArea.setText(eventText.toString());
//     }

//     public static void main(String[] args) {
//         SwingUtilities. invokeLater(() -> {
//             CalendarApp calendarApp = new CalendarApp();
//             //calendarApp.setupDatePicker();
//             calendarApp.setVisible(true);
//         }); 
//     }
// }

