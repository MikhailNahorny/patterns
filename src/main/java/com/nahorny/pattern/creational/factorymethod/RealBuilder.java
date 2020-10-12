package com.nahorny.pattern.creational.factorymethod;

public class RealBuilder implements Builder{
    @Override
    public void build() {
        System.out.println("Builder builds buildings");
    }
}
