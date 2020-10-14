/**
 * это более сложная вариация паттерна (Director - AbstractBuilder - Builder - Product)
 * или (Director - interface Builder - ConcreteBuilder - Product) - большой разницы нет - и наиболее рапространенная
 * позволяет отделить коструирование объекта от его представления
 */

package com.nahorny.pattern.creational.builder.V3;

public abstract class Builder {
    Product product;

    void createProduct(){
        product = new Product();
    }

    abstract void buildModel();
    abstract void buildColor();
    abstract void buildPrice();

    Product getProduct(){
        return product;
    }
}
