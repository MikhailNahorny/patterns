package com.nahorny.pattern.creational.factorymethod;

public class Gap {
    static Type type;

    public static Factory giveFactory(Type type) {
        switch (type) {
            case BODY:
                return new BodyFactory();
            case REAL:
                return new RealFactory();
            case ALGORITHM:
                return new AlgorithmFactory();
            default:
                throw new RuntimeException();
        }
    }

    enum Type {
        BODY, ALGORITHM, REAL
    }
}
