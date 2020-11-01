package com.nahorny.pattern.behavioral.chain;

public class HighPriorityHandler extends Notifier {

    public HighPriorityHandler(int priority) {
        super(priority);
    }

    @Override
    public void inform(String message) {
        System.out.println("Call to police: " + message + "\n Call to owner: " + message);
    }

}
