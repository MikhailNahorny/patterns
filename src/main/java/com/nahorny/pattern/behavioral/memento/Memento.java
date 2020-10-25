package com.nahorny.pattern.behavioral.memento;

public class Memento {
    private final String state;
    private String version;
    private String date;

    public Memento(String state, String version, String date) {
        this.state = state;
        this.version = version;
        this.date = date;
    }

    public String getState() {
        return state;
    }

    protected String getVersion() {
        return version;
    }

    public String getDate() {
        return date;
    }
}
