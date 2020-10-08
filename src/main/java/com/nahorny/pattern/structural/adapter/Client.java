package com.nahorny.pattern.structural.adapter;

public class Client {
    public static void main(String[] args) {
        ClientInterface clientInterface = null;//мы не можем положить сюда UsefulCode, так как он не реализует целевой интерфейс
        clientInterface = new Adapter();
        clientInterface.makeIt();
        clientInterface.removeIt();

    }
}
