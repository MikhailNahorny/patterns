package com.nahorny.extendingandimplementation.p2;

public interface InterB {
    default void method(){
        System.out.println("B");
    }
}
