package com.nahorny.pattern.structural.bridge;

public class Hut extends Building {
    private int square;
    private int floorCount;

    public Hut(Builder builder, int square, int floorCount) {
        super(builder);
        this.square = square;
        this.floorCount = floorCount;
    }

    @Override
    public void build() {
        System.out.println("Hut building in process");
        builder.build(square, floorCount);
    }
}
