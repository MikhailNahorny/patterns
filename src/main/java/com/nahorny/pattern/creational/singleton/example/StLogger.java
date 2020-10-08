/**
 * пример применения синглтона - логгер,
 * который получает аргументом строку - сообщение и логирует его, дополняя некоторой информацией. можно использовать для отладки.
 * для большей читабельности и очевидности, того, что никакая запись не потеряна, все логи будут начинаться с порядкового номера.
 * если будет существовать больше одного экземпляра логеера, в номерах начнется путаница, значит применим синглтон.
 * если нужно отлаживать многопоточный код, то логеер должен быть потокобезопасным. применим Double Checked singleton
 *
 * а еще можно указать, в какой поток выводить сообщение (вывода или ошибок)
 */


package com.nahorny.pattern.creational.singleton.example;

import java.time.format.DateTimeFormatter;

public final class StLogger implements Logger {
    private int counter;
    private static StLogger instance;

    private StLogger() {
        if (instance != null) throw new RuntimeException();
    }

    @Deprecated(since = "use another method to chose out/err stream and to get thread name")
    public void log(String str) {
        final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String dateStr = java.time.LocalTime.now().format(dtf);
        dateStr = dateStr.substring(0, dateStr.indexOf(' ')) + ":" + dateStr.substring(dateStr.indexOf(' ') + 1);
        System.err.printf("%d) %s [%s]: %s\n", ++counter, dateStr, methodName, str);
    } //log (String)

    public void log(String str, boolean isErr) {
        final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String dateStr = java.time.LocalTime.now().format(dtf);
        dateStr = dateStr.substring(0, dateStr.indexOf(' ')) + ":" + dateStr.substring(dateStr.indexOf(' ') + 1);
        String threadName = Thread.currentThread().getName();
        if (isErr) {
            System.err.printf("%d) %s [%s] [%s]: %s\n", ++counter, dateStr, threadName, methodName, str);
        } else {
            System.out.printf("%d) %s [%s] [%s]: %s\n", ++counter, dateStr, threadName, methodName, str);
        }
    } //log (String)

    public static StLogger getLogger() {
        if (instance == null) {
            synchronized (StLogger.class) {
                if (instance == null) instance = new StLogger();
            }
        }
        return instance;
    }//getLogger

} //class StLogger
