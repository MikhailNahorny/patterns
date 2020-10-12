package com.nahorny.pattern.creational.prototype;

public class Client {
    public static void main(String[] args) {
        Prototype prototype = new Prototype(1, "prototype", "object");
        System.out.println(prototype);
        Factory factory = new Factory(prototype);
        for (int i = 0; i < 10; i++) {
            System.out.println(factory.clonePrototype());
        }
    }
}
