package com.nahorny.extendingandimplementation.p5;

public class ImmutableBad {
    final int a;

    public ImmutableBad(int a) {
        this.a = a;
    }

    public int getA() { //you can prevent overriding the getter by marking it final
        return a;
    }
}
