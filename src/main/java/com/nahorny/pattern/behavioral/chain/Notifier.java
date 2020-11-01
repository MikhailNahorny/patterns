package com.nahorny.pattern.behavioral.chain;

public abstract class Notifier {
    private int priority;
    private Notifier nextHandler;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextHandler(Notifier nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void notificationManage(String message, int level) {
        if (level >= priority) {
            inform(message);
        }
        if (nextHandler != null) {
            nextHandler.notificationManage(message, level);
        }
    }

    public abstract void inform(String message);
}
