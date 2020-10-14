package com.nahorny.pattern.creational.builder.V2;

public class Client {

    public static void main(String[] args) {
        System.out.println(new Builder().setColor("Black").setPrice(11).build());
        System.out.println("-----------------------------------------");
        System.out.println(new Builder().setColor("Blue").setPrice(12).build());
    }
}