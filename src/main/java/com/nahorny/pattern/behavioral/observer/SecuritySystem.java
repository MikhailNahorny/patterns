package com.nahorny.pattern.behavioral.observer;

public class SecuritySystem implements Observer {
    private String data;

    @Override
    public void update(String update) {
        this.data = update;
        act();
    }

    private void act() {
        switch (data){
            case "first person came":
                System.out.println("turn off security system");
                break;
            case "the last person left":
                System.out.println("turn on security system");
                break;
            default:
                break;
        }
    }
}
