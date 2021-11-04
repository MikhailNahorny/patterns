package com.nahorny.extendingandimplementation.p6;

public class ChildClass extends BasicClass {

    public void simpleMethod(String s) { //overloaded method
        System.out.println("child simple method with parameter: " + s);
    }

//    public void simpleMethod() { //overridden method
//        System.out.println("Child simple method");
//    }
}
