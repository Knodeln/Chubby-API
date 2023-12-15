package dev.knodeln.chuddy.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date getDateFromString(String dateString) throws ParseException{
        return DATE_FORMAT.parse(dateString);
    }

    public static String getStringFromDate(Date date) {
        return DATE_FORMAT.format(date);
    }

    public static String getCurrentDateAsString() {
        return DATE_FORMAT.format(new Date());
    }
    
    public static Date addDaysToDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }
}
