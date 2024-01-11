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

    public static List<CustomEvent> getEventsForDate(LocalDate date) {
        return calendarModel.getEventsForDate(date);
    }

    public static void addEvent(CustomEvent event) {
        calendarModel.addEvent(event);
    }
}
