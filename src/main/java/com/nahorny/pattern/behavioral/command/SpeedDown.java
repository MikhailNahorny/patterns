package com.nahorny.pattern.behavioral.command;

public class SpeedDown implements Command {
    private final Automobile automobile;

    public SpeedDown(Automobile automobile) {
        this.automobile = automobile;
    }

    @Override
    public void execute() {
        automobile.deceleration();
    }
}
