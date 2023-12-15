package dev.knodeln.chuddy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import dev.knodeln.chuddy.model.CalendarModel;

public class CalendarView extends JFrame {
    private JButton createEventButton;
    private DatePickerView datePicker;
    private JPanel calendarPanel;
    private JLabel titleLabel;
    private JLabel weekLabel;
    private LocalDate displayedWeek;

    public CalendarView(CalendarModel model) {
        super("Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("Kalender", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel weekNavigationPanel = new JPanel(new FlowLayout());
        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(e -> updateWeek(-1));
        
        weekLabel = new JLabel("Week: ", SwingConstants.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> updateWeek(1));

        weekNavigationPanel.add(prevButton);
        weekNavigationPanel.add(weekLabel);
        weekNavigationPanel.add(nextButton);
        
        topPanel.add(weekNavigationPanel, BorderLayout.SOUTH);
        getContentPane().add(topPanel, BorderLayout.NORTH);

        createEventButton = new JButton("Skapa event");
        getContentPane().add(createEventButton, BorderLayout.SOUTH);

        calendarPanel = new JPanel(new GridLayout(0, 1));
        getContentPane().add(new JScrollPane(calendarPanel), BorderLayout.CENTER);

        datePicker = new DatePickerView();

        createEventButton.addActionListener((e -> showDatePicker()));

        datePicker.addSelectDateButtonListener(e -> {
            String selectedDate = datePicker.getSelectedDate();
            if (selectedDate != null && !selectedDate.isEmpty()) {
                hideDatePicker();
            }
        });

        displayedWeek = LocalDate.now();
        updatWeekLabel();
        setLabels(displayedWeek);
        
        JPanel weekNavPanel = new JPanel(new FlowLayout());

        getContentPane().add(weekNavPanel, BorderLayout.SOUTH);
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        createEventButton = new JButton("Skapa event");
        createEventButton.addActionListener(e -> showDatePicker());
        bottomPanel.add(createEventButton);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }

    private void updateWeek(int offset) {
        displayedWeek = displayedWeek.plusWeeks(offset);
        updatWeekLabel();
        setLabels(displayedWeek);
    }

    private void updatWeekLabel() {
        DateTimeFormatter weekFormatter = DateTimeFormatter.ofPattern("'Week: 'w");
        weekLabel.setText(weekFormatter.format(displayedWeek));
    }

    public void addCreateEventButtonListener(ActionListener listener) {
        createEventButton.addActionListener(listener);
    }

    public void showDatePicker() {
        datePicker.setVisible(true);
    }

    public void hideDatePicker() {
        datePicker.setVisible(false);
    }

    public String getSelectedDate() {
        return null;
    }

    private void setLabels(LocalDate weekToDisplay) {
        calendarPanel.removeAll();

        for (DayOfWeek day : DayOfWeek.values()) {
            JLabel dayLabel = new JLabel(day.toString());
            dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
            calendarPanel.add(dayLabel);

            //LocalDate date = weekToDisplay.with(DayOfWeek.of(i));
            LocalDate date = weekToDisplay.with(day);

            JLabel dateLabel = new JLabel(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
            calendarPanel.add(dateLabel);
        }

        revalidate();
        repaint();
    }

    // public void updateEvents(List<CustomEvent> events) {
    //     StringBuilder eventText = new StringBuilder();
    //     for (CustomEvent event : events) {
    //         String eventInfo = event.toString();
    //         eventText.append(eventInfo).append("\n");
    //     }
    //     eventArea.setText("Events: \n" + eventText.toString());
    // }
 


        public static void main(String[] args) {
        SwingUtilities. invokeLater(() -> {
            CalendarModel model = new CalendarModel();
            CalendarView calendarView = new CalendarView(model);
            //calendarApp.setupDatePicker();
            calendarView.setVisible(true);
        }); 
    }
}

