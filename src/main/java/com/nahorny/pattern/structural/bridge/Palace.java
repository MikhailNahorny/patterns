package com.nahorny.pattern.structural.bridge;

public class Palace extends Building {
    private int square;
    private int floorCount;

    public Palace(Builder builder, int square, int floorCount) {
        super(builder);
        this.square = square;
        this.floorCount = floorCount;
    }

    @Override
    public void build() {
        System.out.println("Palace building in process");
        builder.build(square, floorCount);
    }
}
