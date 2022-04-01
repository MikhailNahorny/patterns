package com.nahorny.threads.callable.ex2;

import com.nahorny.automationqa.utils.Dates;
import com.nahorny.collections.myimplementation.Logger;

import java.util.concurrent.Callable;

public class Ex1 {

    static String method(Callable<String> c) {
        try {
            return c.call();
        } catch (Exception ignored) {
        }
        return null;
    }

    static Callable<String> callable = () -> {
        Logger.log(Thread.currentThread().getName());
        return Dates.now().timeStamp();
    };

    static void method2(Runnable r) {
        r.run();
    }

    static Runnable runnable = () -> {
        Logger.log("do something");
        Logger.log("do something");
    };

    public static void main(String[] args) {
        method(callable); //instance of Callable
        method(() -> {
            System.out.println();
            System.out.println();
            return null;
        });
        method(() -> Dates.now().timeStamp()); //lambda

        method(new Callable<String>() {

            @Override public String call() throws Exception {
                return null; //anonymous implementation os interface
            }
        });

        method2(runnable);
        method2(() -> Logger.log("nul"));
        method2(() -> {
            Logger.log("nul");
            Logger.log("nul");
        });
    }

}
