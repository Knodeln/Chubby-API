package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.model.CalendarModel;
import dev.knodeln.chuddy.model.CustomEvent;
import dev.knodeln.chuddy.utilities.DateUtils;
import dev.knodeln.chuddy.view.CalendarView;
import dev.knodeln.chuddy.view.DatePickerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

public class CalendarController {
    private CalendarModel model;
    private CalendarView view;
    private DatePickerView datePicker;  

    public CalendarController(CalendarModel model, CalendarView view) {
        this.model = model;
        this.view = view;

        datePicker = new DatePickerView();

        view.addCreateEventButtonListener(new CreateEventListener());
        datePicker.addSelectDateButtonListener(new DatePickerButtonListener());

    }

    private class CreateEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showDatePicker();
        }
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


            model.setSelectedDate(selectedDate);
            view.hideDatePicker();
        }
    }
}
