/**
 * абстракция, так как содержит приватные поля, испльзуем абстракный класс
 */

package com.nahorny.pattern.structural.bridge;

public abstract class Building {
    protected Builder builder;

    public Building(Builder builder) {
        this.builder = builder;
    }

    public abstract void build();
}
