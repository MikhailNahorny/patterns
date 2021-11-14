package com.nahorny.inheritanceandimplementation.p1staticmethodhiding;

public class BClass extends AClass implements Cloneable {
    //this field will never be used, because public static String b declared in basic AClass
    //we can only use getter for this field and hide it (getter) - see CClass
    public static String b = "static field in BClass";
}
