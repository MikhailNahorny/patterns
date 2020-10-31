package com.nahorny.extendingandimplementation.p2;

public interface InterA {

    //keywords public static final are redundant, because all field in interface such and only such, unlike the abstract class
     public static final int x = 10;
    default void method(){
        System.out.println("A");
    }
}
