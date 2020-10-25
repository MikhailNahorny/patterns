package com.nahorny.pattern.behavioral.memento;

import java.time.format.DateTimeFormatter;

public class Originator {
    private String state;
    private int version;
    private String date;


    protected void setState(String state) {
        this.state = state;
    }

    protected String getState() {
        return state;
    }

    public Memento saveState() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        date = java.time.LocalTime.now().format(dtf);
        return new Memento(state, String.valueOf(version++), date);
    }

    public void restoreState(Memento memento) {
        this.state = memento.getState();
    }
}
