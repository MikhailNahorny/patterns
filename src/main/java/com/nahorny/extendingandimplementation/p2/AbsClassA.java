package com.nahorny.extendingandimplementation.p2;

public abstract class AbsClassA {
    private int y;
    //keywords public static final are not redundant because field can be not static, not public, not final
    public static final int z = 10;

    /**
     * инстанция абстрактоного класса не может быть создана, однако конструктор есть
     * и может быть вызван первой строкой в конструкторе класса-наследника
     */
    public AbsClassA(int y) {
        this.y = y;
    }

    /**
     * это абстрактный метод
     */
    public abstract void method1();

    public void method2() {
        System.out.println("это метод с реализацией");
    }
}
