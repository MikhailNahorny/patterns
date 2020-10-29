package com.nahorny.pattern.behavioral.template;

public abstract class GoAtWorkTemplate {
    private void wakeUp(){
        System.out.println("I'm waking up");
    }

    protected abstract void goAtWork();

    private void doWork(){
        System.out.println("I'm working");
    }

    public final void active(){
        wakeUp();
        goAtWork();
        doWork();
    }
}
