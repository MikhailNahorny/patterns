package com.nahorny.threads.callable.ex2;

import com.nahorny.automationqa.utils.Dates;
import com.nahorny.collections.myimplementation.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MyCall implements Callable {

    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(500);
        return Thread.currentThread().getName() + Dates.now().timeStamp("_yyyy.MM.dd_HH.mm.ss:SSS");
    }

    public static void main(String args[]) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<>();
        Callable<String> callable = new MyCall();

//        es.execute(MyCall::new);

        for (int i = 0; i < 100; i++) {
            Future<String> future = es.submit(callable);
            list.add(future);
        }

        for (Future<String> fut : list) {
            try {
                Logger.log(fut.get());
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }
//        CompletableFuture
//                .supplyAsync(() -> {
//                    return 50;
//                })
//                .thenApply(x -> x * 2)
//                .thenAccept(System.out::println);

        es.shutdown();
    }
}
