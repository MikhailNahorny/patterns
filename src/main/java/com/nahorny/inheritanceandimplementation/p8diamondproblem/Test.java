package com.nahorny.inheritanceandimplementation.p8diamondproblem;

public class Test implements First, Second {

    @Override
    public void simpleMethod() { //compilation error without overriding
        //Second.super.simpleMethod();
    }
}
