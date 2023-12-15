package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.model.CalendarModel;
import dev.knodeln.chuddy.model.CustomEvent;
import dev.knodeln.chuddy.utilities.DateUtils;
import dev.knodeln.chuddy.view.CalendarView;
import dev.knodeln.chuddy.view.DatePickerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalendarController {
    private static final CalendarModel calendarModel = new CalendarModel();
    private CalendarView view;
    private DatePickerView datePicker;

    public static List<CustomEvent> getEventsForDate(LocalDate date) {
        return calendarModel.getEventsForDate(date);
    }

/*    private class CreateEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showDatePicker();
        }
    }*/
    public static void addEvent(CustomEvent event) {
        calendarModel.addEvent(event);
    }



    // public void handleSelectedDate(String selectedDate, String eventName) {
    //     try { 
    //         Date eventDate = DateUtils.getDateFromString(selectedDate);
    //         CustomEvent event = new CustomEvent(eventName, eventDate);
    //     } catch (ParseException ex) {
    //         ex.printStackTrace();
    //     }
    // }

    private class DatePickerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedDate = view.getSelectedDate();


            calendarModel.setSelectedDate(selectedDate);
            view.hideDatePicker();
        }
    }
}
