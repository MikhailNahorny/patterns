package com.nahorny.inheritanceandimplementation.p6accessmodifiers;

public class Test {
    public static void main(String[] args) {
        BasicClass bc = new BasicClass();
        bc.simpleMethod();//only one method is available for BasicClass instance
        ChildClass cc = new ChildClass();
        cc.simpleMethod(); // both methods are available for ChildClass
        cc.simpleMethod("parameter");
        bc = (BasicClass) cc;
        bc.simpleMethod();
        System.out.println(
                bc.defaultField
                + bc.protectedField
                + bc.publicField
        );

    }
}
