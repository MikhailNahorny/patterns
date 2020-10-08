/**
 * Double Checked singleton
 * потокобезопасно
 * синхронизированный блок выполняется только при инициализации
 * использование volatile модификатора может привести к проблемам производительности на мультипроцессорных системах / https://habr.com/ru/post/27108/
 * почему не работает без volatile: https://habr.com/ru/post/129494/
 */

package com.nahorny.pattern.creational.singleton;

public class Singleton5 {

    private static volatile Singleton5 instance;

    private Singleton5() {
        if (instance != null) throw new RuntimeException();
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) instance = new Singleton5();
            }
        }
        return instance;
    }
}
