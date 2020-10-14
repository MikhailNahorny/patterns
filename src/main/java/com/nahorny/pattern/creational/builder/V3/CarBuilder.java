package com.nahorny.pattern.creational.builder.V3;

public class CarBuilder extends Builder {
    @Override
    void buildModel() {
        product.setModel("Crossover");
    }

    @Override
    void buildColor() {
        product.setColor(Color.BLUE);
    }

    @Override
    void buildPrice() {
        product.setPrice(30_000);
    }
}
