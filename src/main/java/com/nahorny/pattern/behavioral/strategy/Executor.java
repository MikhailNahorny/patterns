package com.nahorny.pattern.behavioral.strategy;

public class Executor {
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void execute(){
        strategy.doIt();
    }
}
