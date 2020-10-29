/**
 * Template method
 * определяет основу алгоритма и позволяет наследникам переопределять некоторые шаги алгоритма, не изменяя его структуру в целом
 * <p>
 * что-то в голову ничего не приходит, потому примером будет связка проснуться, поехать на работу, поработать, где все одинаковое, кроме поехать
 * поехать можно на автобусе, велосипеде, автомобиле.
 * суть в том, что можно написать отдельны класс на каждый из трех варинтов, но это нарушает принцип DRY, так как проснуться и поработать во всех вариантах одинаково.
 */
package com.nahorny.pattern.behavioral.template;

public class Client {
    public static void main(String[] args) {
        GoAtWorkTemplate bicycle = new Bicycle();
        GoAtWorkTemplate bus = new Bus();
        GoAtWorkTemplate auto = new Automobile();

        System.out.println("\nYesterday:");
        bicycle.active();
        System.out.println("\nToday:");
        bus.active();
        System.out.println("\nTomorrow");
        auto.active();
    }
}
