package com.nahorny.inheritanceandimplementation.p6accessmodifiers;

public class BasicClass {
    private int privateField; //accessible in this class only
    int defaultField; //accessible in this class + this package
    protected int protectedField; //accessible in this class + this package + child classes
    public int publicField; //accessible anywhere

    public void simpleMethod(){
        System.out.println("basic simple method");
    }
}
