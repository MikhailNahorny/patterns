package com.nahorny.pattern.behavioral.observer;

import java.util.LinkedList;

public class WeatherStation implements Observable {
    private String data;
    private LinkedList<Observer> observers;

    public WeatherStation() {
        this.observers = new LinkedList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(data);
        }
    }

    public void updateData(String data){
        this.data = data;
    }
}
