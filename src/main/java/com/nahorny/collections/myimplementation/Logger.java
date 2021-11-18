package com.nahorny.collections.myimplementation;

import java.time.format.DateTimeFormatter;

public final class Logger {
    private static int counter;

    private Logger() {
    }

    public static void log(String str) {
        logInternal(str, false);
    }

    public static void log(String str, boolean isErr) {
        logInternal(str, isErr);
    }

    private static void logInternal(String str, boolean isErr) {
        final String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String dateStr = java.time.LocalTime.now().format(dtf);
        dateStr = dateStr.substring(0, dateStr.indexOf(' ')) + ":" + dateStr.substring(dateStr.indexOf(' ') + 1);
        if (isErr) {
            System.err.printf("%d) %s [%s]: %s\n", ++counter, dateStr, methodName, str);
        } else {
            System.out.printf("%d) %s [%s]: %s\n", ++counter, dateStr, methodName, str);
        }
    }
}
