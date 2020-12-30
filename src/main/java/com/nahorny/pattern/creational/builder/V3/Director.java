package com.nahorny.pattern.creational.builder.V3;

public class Director {
    Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    Product buildProduct(){
        builder.createProduct();
        builder.buildModel();
        builder.buildColor();
        builder.buildPrice();

        return builder.getProduct();
    }
}
