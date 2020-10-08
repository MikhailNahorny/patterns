/**
 * не потокобезопасный
 * ленивый, создает экземпляр по первому запросу
 */

package com.nahorny.pattern.creational.singleton;


public final class Singleton1 {
    //field to save instance
    private static Singleton1 instance;
    //hide constructor
    private Singleton1() {
    }
    //public method return only one instance
    public static Singleton1 getSingleton() {
        return instance = (instance == null) ? new Singleton1() : instance;
    }
}


