package com.nahorny.pattern.behavioral.chain;

public class MiddlePriorityHandler extends Notifier {

    public MiddlePriorityHandler(int priority) {
        super(priority);
    }

    @Override
    public void inform(String message) {
        System.out.println("Send SMS: " + message + "\n Call to neighbors");
    }
}
