package com.example.dddcorestudy.application.test.util;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTestUtil {

    private static final DateTimeFormatter DATE_FORMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static LocalDateTime toDate(@NonNull final String date) {
        return LocalDateTime.parse(date, DATE_FORMT);
    }

    public static LocalDateTime toDate(@NonNull final String date, @NonNull final String time) {
        return LocalDateTime.parse(date + " " + time, DATE_TIME_FORMT);
    }

}
