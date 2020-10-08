package com.nahorny.pattern.behavioral.strategy;

public class ConcreteStrategyA implements Strategy {

    @Override
    public void doIt() {
        System.out.println("Do smth like A");
    }
}
