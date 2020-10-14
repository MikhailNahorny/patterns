package com.nahorny.pattern.creational.builder.V3;

public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        //director.setBuilder(new CupBuilder());

        director.setBuilder(new CarBuilder());

        Product product = director.buildProduct();

        System.out.println(product);

    }
}
