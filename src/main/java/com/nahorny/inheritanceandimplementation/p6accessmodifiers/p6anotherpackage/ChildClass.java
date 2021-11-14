package com.nahorny.inheritanceandimplementation.p6accessmodifiers.p6anotherpackage;

import com.nahorny.inheritanceandimplementation.p6accessmodifiers.BasicClass;

public class ChildClass extends BasicClass {
    public void getProtectedField() {
        System.out.println(protectedField); //ChildClass extend BasicClass and have access to protected members
        System.out.println(publicField);// accessible anywhere
    }
}
