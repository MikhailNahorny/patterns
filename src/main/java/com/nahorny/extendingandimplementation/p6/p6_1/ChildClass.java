package com.nahorny.extendingandimplementation.p6.p6_1;

import com.nahorny.extendingandimplementation.p6.BasicClass;

public class ChildClass extends BasicClass {
    public void getProtectedField() {
        System.out.println(protectedField); //ChildClass extend BasicClass and have access to protected members
        System.out.println(publicField);// anywhere
    }
}
