package com.nahorny.inheritanceandimplementation.p1staticmethodhiding;

public class AClass {
    private String a = "non static field in AClass";
    public static String b = "static field in AClass";

    public String getA() {
        return a;
    }

    public static String getB() {
        return b;
    }

}
