/**
 * конкретная реализация 2
 */
package com.nahorny.pattern.structural.bridge;

public class Bricklayer implements Builder {
    @Override
    public void build(int square, int floorCount) {
        System.out.println("Brickl building with square=" + square + " and " + floorCount + " floors");
    }
}
