package com.nahorny.inheritanceandimplementation.p5immutable;

public class Main {
    public static void main(String[] args) {
        Mutable mut = new Mutable(1);
        ImmutableBad immu = (ImmutableBad) mut;
        System.out.println(immu.getA());
        mut.setA(2);
        System.out.println(immu.getA());

        Mu mu = new Mu(0);
        Imm imm = (Imm) mu;
        System.out.println(imm.value);
        mu.value = 3;
        System.out.println(imm.value);
    }
}
