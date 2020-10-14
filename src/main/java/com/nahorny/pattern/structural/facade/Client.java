package com.nahorny.pattern.structural.facade;

public class Client {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.makeCoffee();
    }
}
