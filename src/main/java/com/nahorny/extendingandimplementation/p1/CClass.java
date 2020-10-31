package com.nahorny.extendingandimplementation.p1;

public class CClass extends AClass {
    //@Override - error - this place we can not override public static int getB()
    // we can hide parent's method. looks the same, but not overriding
    public static String getB(){
        return "static method in CClass hide AClass' one";
    }
}
