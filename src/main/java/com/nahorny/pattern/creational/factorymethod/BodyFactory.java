package com.nahorny.pattern.creational.factorymethod;

public class BodyFactory implements Factory {
    @Override
    public Builder create() {
        return new BodyBuilder();
    }
}
