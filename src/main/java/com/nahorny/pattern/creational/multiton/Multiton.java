/**
 * Multiton
 * максимальное количество объектов такого класса известно заранее
 * эта реализация не потокобезопасна. при необходимости добавить Double Check Locking
 */
package com.nahorny.pattern.creational.multiton;

import java.util.HashMap;

public class Multiton {
    private static final HashMap<MultitonOrdinal, Multiton> instances = new HashMap<>();
    private MultitonOrdinal ordinal;

    private Multiton(MultitonOrdinal ordinal) {
        this.ordinal = ordinal;
    }

    public static Multiton getInstance(MultitonOrdinal ordinal){
        if(!instances.containsKey(ordinal)){
            instances.put(ordinal, new Multiton(ordinal));
        }
        return instances.get(ordinal);
    }

    @Override
    public String toString() {
        return "Multiton{" +
                "ordinal=" + ordinal +
                '}';
    }
}