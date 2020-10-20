package com.nahorny.pattern.behavioral.command;

public class Stop implements Command {
    private final Automobile automobile;

    public Stop(Automobile automobile) {
        this.automobile = automobile;
    }

    @Override
    public void execute() {
        automobile.stop();
    }
}
