package com.nahorny.extendingandimplementation.p2;

public interface InterC extends InterA {
    //interfaces default implementation can be overridden
    @Override
    default void method(){
        System.out.println("C. this means that default implementation was overridden");
    }
}
