package com.zerodhatech.godavari;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeUtil {
    public static String getWeekDayName() {
        return LocalDate.now().getDayOfWeek().name();
    }

    /***
     * returns valid trading time if it is greater than 15:15 hours
     * @return
     */
    public static boolean isValidOptionsTradingTime() {
        LocalDateTime now = LocalDateTime.now();
        Integer hour = now.getHour();
        Integer minutes = now.getMinute();
        if(hour>=15 && minutes>=15) {
            return true;
        }
        return false;
    }
}
