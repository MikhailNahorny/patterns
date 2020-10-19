package com.nahorny.pattern.structural.composite;

public class Painter implements Worker {
    @Override
    public void doWork() {
        System.out.println("Painter do his job");
    }
}
