/**
 * решение Билла Пью / On Demand Holder idiom
 * нет блокировки, когда эекземпляр уже инициализирован и 2 потока запрашивают его
 * самый быстрый
 */

package com.nahorny.pattern.creational.singleton;

public final class Singleton4 {

    private Singleton4(){
    }

    private static class SingletonHolder{
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }
}
