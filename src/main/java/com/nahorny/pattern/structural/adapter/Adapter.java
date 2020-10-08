/**
 * Адаптер позволяет подружить классы с несовместимыми контрактами:
 * класс (Adaptee), предоставляющий нечто делает это посредством вызова метода doIt()
 * класс (Client), который принимает объект, который предоставляет нечто,
 * но клиент хочет получать нечто по методу makeIt() и изменить это мы не можем.
 * <p>
 * проблему решает класс Adapter, реаилзующий интерфейс, который подходит Client, унаследованный от Adaptee
 * где в переопределении метода make() будет вызван метод do()
 * <p>
 * у нас Adaptee назван UsefulCode
 */

package com.nahorny.pattern.structural.adapter;

public class Adapter extends UsefulCode implements ClientInterface {
    @Override
    public void makeIt() {
        doIt();
    }

    @Override
    public void removeIt() {
        deleteIt();
    }
}
