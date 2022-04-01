/**
 * Double Checked singleton
 * потокобезопасно
 * синхронизированный блок выполняется только при инициализации
 * использование volatile модификатора может привести к проблемам производительности на мультипроцессорных системах / https://habr.com/ru/post/27108/
 * почему не работает без volatile: https://habr.com/ru/post/129494/
 *
 * при работе в потоках, каждый создает свою кэшированную копию переменной и работает с нет. модификатор volatile указывет на то,
 * что локальные копии переменной в потоках не должны быть созданы, а каждое обращение к переменной (чтение/запись) обращается
 * непосредственно к оригинальной переменной ("антоним" этому - ThreadLocal)
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
