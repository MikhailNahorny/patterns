/**
 * конкретная реализация 1
 */
package com.nahorny.pattern.structural.bridge;

public class Carpenter implements Builder {
    @Override
    public void build(int square, int floorCount) {
        System.out.println("Wooden building with square=" + square + " and " + floorCount + " floors");
    }
}
