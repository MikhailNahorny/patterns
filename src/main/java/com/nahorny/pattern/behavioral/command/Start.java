package com.nahorny.pattern.behavioral.command;

public class Start implements Command {
    private final Automobile automobile;

    public Start(Automobile automobile) {
        this.automobile = automobile;
    }

    @Override
    public void execute() {
        automobile.start();
    }
}
