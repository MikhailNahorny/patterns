package com.nahorny.pattern.behavioral.observer;

public class ClimateControlSystem implements Observer {
    private String data;

    @Override
    public void update(String update) {
        this.data = update;
        act();
    }

    private void act() {
        switch (data){
            case "first person came":
            case "time to wake up":
                System.out.println("turn on climate control");
                break;
            case "the last person left":
            case "time to sleep":
                System.out.println("turn off climate control");
                break;
            case "the weather is getting more comfortable":
                System.out.println("reduce the power of the climate control");
                break;
            case "the weather is getting less comfortable":
                System.out.println("increase the power of the climate control");
                break;
            default:
                break;
        }
    }
}
