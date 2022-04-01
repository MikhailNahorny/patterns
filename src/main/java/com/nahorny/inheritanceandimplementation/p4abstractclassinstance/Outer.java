package com.nahorny.inheritanceandimplementation.p4abstractclassinstance;

public class Outer {
    abstract class Inner {
        //static int i; compilation error. static members allowed only for static inner class. OK if add static to Inner.
    }
}
