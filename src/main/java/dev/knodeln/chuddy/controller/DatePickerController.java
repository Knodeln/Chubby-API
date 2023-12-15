package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.model.DatePickerModel;
import dev.knodeln.chuddy.view.DatePickerView;
import dev.knodeln.chuddy.utilities.DateUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

public class DatePickerController {
    private DatePickerModel model;
    private DatePickerView view;
    

    public DatePickerController(DatePickerModel model, DatePickerView view) {
        this.model = model;
        this.view = view;

        view.addSelectDateButtonListener(new SelectedDateButtonListener());
    }

    private class SelectedDateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int day = view.getSelectedDay();
            String month = view.getSelectedMonth();
            int year = view.getSelectedYear();

            String selectedDateString = day + " " + month + " " + year;

            try {
                Date selectedDate = DateUtils.getDateFromString(selectedDateString);
                String formattedDate = DateUtils.getStringFromDate(selectedDate);

                model.setSelectedDate(formattedDate);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }
}
