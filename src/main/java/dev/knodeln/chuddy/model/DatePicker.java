package dev.knodeln.chuddy.model;
import java.util.Calendar;
import javax.swing.*;

// public class DatePicker extends JFrame {
//     public interface DateSelectedListener {
//         // void onDateSelected(String selectedDate);
//     }

//     private DateSelectedListener listener;

//     public void addDateSelectedListener(DateSelectedListener listener) {
//         this.listener = listener;
//     }

//     private void notifyDateSelected(String selectedDate) {
//         if (listener != null) {
//             listener.onDateSelected(selectedDate);
//         }
//     }

//     private JComboBox<Integer> dayCbx;
//     private JComboBox<String> monthCbx;
//     private JComboBox<Integer> yearCbx;

//     public DatePicker() {
//         super("Simple Date Picker");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(320,150);
//         setLocationRelativeTo(null);

//         JPanel panel = new JPanel();

//         //Kunna välja dag
//         dayCbx = new JComboBox<>();
//         for (int i = 1; i <= 31; i++) {
//             dayCbx.addItem(i);
//         }
    
//         //Kunna välja månad
//         String[] months = {"Januari", "Februari", "Mars", "April", "Maj", "Juni", "Juli",
//                 "Augusti", "September", "Oktober", "Nomvember", "December"};
//         monthCbx = new JComboBox<>(months);

//         // Kunna välja år, från och med detta och 5 år fram
//         yearCbx = new JComboBox<>();
//         int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//         for (int i = currentYear; i <= currentYear + 5; i++) {
//             yearCbx.addItem(i);
//         }

//         panel.add(dayCbx);
//         panel.add(monthCbx);
//         panel.add(yearCbx);

//         JButton selectDateButton = new JButton("Välj datum");
//         selectDateButton.addActionListener(e -> {
//             int day = (int) dayCbx.getSelectedItem();
//             String month = (String) monthCbx.getSelectedItem();
//             int year = (int) yearCbx.getSelectedItem();

//             // Do something with the selected date
//             String selectedDate = day + " " + month + " " + year;
//             notifyDateSelected(selectedDate);

//         });
//         // panel.add(selectDateButton);

//         add(panel);
//     }

//     // public static void main(String[] args) {
//     //     SwingUtilities.invokeLater(() -> {
//     //         DatePicker datePicker = new DatePicker();
//     //         datePicker.setVisible(true);
//     //     });
//     // }
// }
