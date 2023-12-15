    package dev.knodeln.chuddy.view;

    import dev.knodeln.chuddy.controller.CalendarController;
    import dev.knodeln.chuddy.model.CustomEvent;
    import dev.knodeln.chuddy.model.Event;

    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.time.LocalDate;
    import java.util.Arrays;
    import java.util.Calendar;
    import java.util.List;

    public class DatePickerView extends JFrame {
        private JComboBox<Integer> dayCbx;
        private JComboBox<String> monthCbx;
        private JComboBox<Integer> yearCbx;
        private JButton createEventButton;

        private JTextField eventNameTextField;
        String[] months = {"Januari", "Februari", "Mars", "April", "Maj", "Juni", "Juli",
                "Augusti", "September", "Oktober", "November", "December"};

        public DatePickerView() {
            super("Simple date picker");
            JFrame frame = this;

            setSize(320, 150);  
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();

            JLabel eventNameLabel = new JLabel("Event name:");
            eventNameTextField = new JTextField(20);  // Set the desired width of the text field

            panel.add(eventNameLabel);
            panel.add(eventNameTextField);

            //Kunna välja dag
            dayCbx = new JComboBox<>();
            for (int i = 1; i <= 31; i++) {
                dayCbx.addItem(i);
            }

            monthCbx = new JComboBox<>(months);

            // Kunna välja år, från och med detta och 5 år fram
            yearCbx = new JComboBox<>();
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            for (int i = currentYear; i <= currentYear + 5; i++) {
                yearCbx.addItem(i);
            }

            panel.add(dayCbx);
            panel.add(monthCbx);
            panel.add(yearCbx);

            createEventButton = new JButton("Create event");
            panel.add(createEventButton);
            createEventButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createEvent();
                }
            });

            add(panel);

        }

        public void createEvent() {
            LocalDate date = LocalDate.parse(getSelectedYear() + "-" + getSelectedMonth() + "-" + getSelectedDay());
            CalendarController.addEvent(new CustomEvent(eventNameTextField.getText(), date));
            this.dispose();
        }

        public void addSelectDateButtonListener(ActionListener listener) {
            createEventButton.addActionListener(listener);
        }

        public String getSelectedDate() {
                int day = (int) dayCbx.getSelectedItem();
                String month = (String) monthCbx.getSelectedItem();
                int year = (int) yearCbx.getSelectedItem();

                // Do something with the selected date
                return day + " " + month + " " + year;
        }

        public String getSelectedDay() {
            if (dayCbx.getSelectedIndex() + 1 < 10) {
                return "0" + dayCbx.getSelectedItem();
            }
            return dayCbx.getSelectedItem().toString();
        }

        public String getSelectedMonth() {
            List<String> monthList = Arrays.stream(months).toList();
            if(monthList.indexOf(monthCbx.getSelectedItem()) + 1 < 10) {
                return "0" + (monthList.indexOf(monthCbx.getSelectedItem()) + 1);
            }
            return String.valueOf(monthList.indexOf(monthCbx.getSelectedItem()) + 1);
        }

        public int getSelectedYear() {
            return (int) yearCbx.getSelectedItem();
        }
    }
