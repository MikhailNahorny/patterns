package com.nahorny.inheritanceandimplementation.p8diamondproblem;

public interface Second {
    default void simpleMethod(){
        System.out.println("Second interface default method");
    }
}
