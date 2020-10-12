package com.nahorny.pattern.creational.factorymethod;

public class AlgorithmBuilder implements Builder{
    @Override
    public void build() {
        System.out.println("Builder builds algorithm");
    }
}
