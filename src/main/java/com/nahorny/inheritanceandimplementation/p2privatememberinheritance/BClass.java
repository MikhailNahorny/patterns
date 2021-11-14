package com.nahorny.inheritanceandimplementation.p2privatememberinheritance;

public class BClass extends AClass {
    @Override
    public void method() {
        System.out.println("BClass overridden method was called");
    }

    public void newMethod(){
        System.out.println("method added in BClass, but absent in AClass");
    }
}
