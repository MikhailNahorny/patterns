/*
  пример применения синглтона - логгер,
  который получает аргументом строку - сообщение и логирует его, дополняя некоторой информацией. можно использовать для отладки.
  для большей читабельности и очевидности, того, что никакая запись не потеряна, все логи будут начинаться с порядкового номера.
  если будет существовать больше одного экземпляра логеера, в номерах начнется путаница, значит применим синглтон.
  если нужно отлаживать многопоточный код, то логеер должен быть потокобезопасным. применим Double Checked singleton

  а еще можно указать, в какой поток выводить сообщение (вывода или ошибок)
 */


package com.nahorny.pattern.creational.singleton.example;

import java.time.format.DateTimeFormatter;

public final class Logger {
    private int counter;
    private static Logger instance;

    private Logger() {
        if (instance != null) throw new RuntimeException();
    }

    public void log(String str, boolean isErr) {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        final String methodName = (stack[2].getMethodName().equalsIgnoreCase("log")) ? stack[3].getMethodName() : stack[2].getMethodName();
        //final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String dateStr = java.time.LocalTime.now().format(dtf);
        dateStr = dateStr.substring(0, dateStr.indexOf(' ')) + ":" + dateStr.substring(dateStr.indexOf(' ') + 1);
        String threadName = Thread.currentThread().getName();
        if (isErr) {
            System.err.printf("%d) %s [%s] [%s]: %s\n", ++counter, dateStr, threadName, methodName, str);
        } else {
            System.out.printf("%d) %s [%s] [%s]: %s\n", ++counter, dateStr, threadName, methodName, str);
        }
    } //log (String, boolean)

    public void log(String str){
        log(str, true);
    }

    public static Logger getLogger() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) instance = new Logger();
            }
        }
        return instance;
    }//getLogger

} //class
