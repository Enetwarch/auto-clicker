package com.github.enetwarch.autoclicker.util;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Format {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void printMessage(String message) {
        System.out.printf("[%s] %s%n", getDateTime(), message);
    }

    private static String getDateTime() {
        return LocalDateTime.now().format(dateTimeFormatter);
    }

}