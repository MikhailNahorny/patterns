package com.nahorny.pattern.structural.composite;

public class Carpenter implements Worker {
    @Override
    public void doWork() {
        System.out.println("Carpenter do his job");
    }
}
