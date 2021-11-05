/**
 * simple example of Polymorphism
 */
package com.nahorny.inheritanceandimplementation.p7polymorphism;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        Cat cat = new Cat();
        Dog dog = new Dog();
        animals[0] = cat;
        animals[1] = dog;
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
