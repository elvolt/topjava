package ru.javawebinar.topjava.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        if (startTime == null) {
            startTime = LocalTime.MIN;
        }
        if (endTime == null) {
            endTime = LocalTime.MAX;
        }
        return !lt.isBefore(startTime) && lt.isBefore(endTime);
    }

    public static boolean isBetweenClosed(LocalDateTime ldt, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime == null && endDateTime != null) {
            return ldt.compareTo(endDateTime) <= 0;
        } else if (startDateTime != null && endDateTime == null) {
            return ldt.compareTo(startDateTime) >= 0;
        } else if (startDateTime != null) {
            return ldt.compareTo(startDateTime) >= 0 && ldt.compareTo(endDateTime) <= 0;
        } else {
            return true;
        }
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }
}

