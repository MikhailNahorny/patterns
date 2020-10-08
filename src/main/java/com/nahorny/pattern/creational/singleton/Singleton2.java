/**
 * потокобезопасный
 * нетерпеливый, создает экземпляр сразу
 */
package com.nahorny.pattern.creational.singleton;

public final class Singleton2 {
    //field to save instance
    private static Singleton2 instance = new Singleton2();
    //hide constructor
    private Singleton2() {
    }
    //public method return only one instance
    public static Singleton2 getSingleton() {
        return instance;
    }
}
