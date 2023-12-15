    package dev.knodeln.chuddy.view;

    import javax.swing.*;
    import java.awt.event.ActionListener;
    import java.util.Calendar;

    public class DatePickerView extends JFrame {
        private JComboBox<Integer> dayCbx;
        private JComboBox<String> monthCbx;
        private JComboBox<Integer> yearCbx;
        private JButton selectDateButton;

        public DatePickerView() {
            super("Simple date picker");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(320, 150);  
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();

            //Kunna välja dag
            dayCbx = new JComboBox<>();
            for (int i = 1; i <= 31; i++) {
                dayCbx.addItem(i);
            }
        
            //Kunna välja månad
            String[] months = {"Januari", "Februari", "Mars", "April", "Maj", "Juni", "Juli",
                    "Augusti", "September", "Oktober", "Nomvember", "December"};
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

            selectDateButton = new JButton("Välj datum");
            panel.add(selectDateButton);

            add(panel);

        }

        public void addSelectDateButtonListener(ActionListener listener) {
            selectDateButton.addActionListener(listener);
        }

        public String getSelectedDate() {
                int day = (int) dayCbx.getSelectedItem();
                String month = (String) monthCbx.getSelectedItem();
                int year = (int) yearCbx.getSelectedItem();

                // Do something with the selected date
                return day + " " + month + " " + year;
        }

        public int getSelectedDay() {
            return (int) dayCbx.getSelectedItem();
        }

        public String getSelectedMonth() {
            return (String) monthCbx.getSelectedItem();
        }

        public int getSelectedYear() {
            return (int) yearCbx.getSelectedItem();
        }
    }
