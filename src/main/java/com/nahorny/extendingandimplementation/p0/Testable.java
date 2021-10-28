package com.nahorny.extendingandimplementation.p0;

public interface Testable {

    static String getStringStatic(){
        return "Testable interface string static";
    }

    default String getStringDefault(){
        return "Testable interface string default";
    }
}
