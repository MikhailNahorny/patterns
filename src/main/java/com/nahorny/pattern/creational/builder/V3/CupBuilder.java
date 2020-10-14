package com.nahorny.pattern.creational.builder.V3;

public class CupBuilder extends Builder {
    @Override
    void buildModel() {
        product.setModel("beerCup");
    }

    @Override
    void buildColor() {
        product.setColor(Color.GREEN);
    }

    @Override
    void buildPrice() {
        product.setPrice(30);
    }
}
