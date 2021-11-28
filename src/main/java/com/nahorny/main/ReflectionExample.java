package com.nahorny.main;

import com.nahorny.pattern.creational.singleton.Singleton1;

import java.lang.reflect.Constructor;

public class ReflectionExample {
    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getSingleton();
        Singleton1 instance2 = null;
        try {
            Constructor[] constructors = Singleton1.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instance2 = (Singleton1) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("instance1.hashCode():- " + instance1.hashCode());
        System.out.println("instance2.hashCode():- " + instance2.hashCode());
    }
}
