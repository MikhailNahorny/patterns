package com.nahorny.pattern.behavioral.chain;

public class LowPriorityHandler extends Notifier {

    public LowPriorityHandler(int priority) {
        super(priority);
    }

    @Override
    public void inform(String message) {
        System.out.println("Send email: " + message);
    }
}
