/**
 * в такой вариации билдер (Client - Builder - Product) имеет место быть, призван выполнить ту же задачу, что и V1.URL.Composer, но все несколько неочевидно и нелогично на мой взгляд.
 * остается вопрос: что если не все поля были установлены? где это контролировать?
 * конструктор Product публичный, но требует объета Builder, однако конструктор Builder тоже публичный, а значит нет препядствий создать объект Product в неправильном/неожиданном состоянии
 * я вижу в такой реализации нарушение принципа High Cohesion and low coupling и нарушение инкапсуляции (в разрезе ограничения доступа)
 */

package com.nahorny.pattern.creational.builder.V2;

public final class Builder {

    private String color;
    private int price;

    public Builder() {
    }

    public Builder setColor(String color) {
        this.color = color;
        return this;
    }

    public Builder setPrice(int price) {
        this.price = price;
        return this;
    }

    protected String getColor() {
        return color;
    }

    protected int getPrice() {
        return price;
    }

    public Product build() {
        return new Product(this);
    }
}