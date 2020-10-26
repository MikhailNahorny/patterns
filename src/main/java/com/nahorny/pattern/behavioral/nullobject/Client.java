/**
 * Null Object. наследует класс, объект которого должен быть возвращен неким методом, но может быть возвращен нулл вместо объекта.
 * позволяет отказаться от проверок на нулл.
 * Википедия считает его поведенческим шаблоном, однако другие ресурсы к таковым не относят. я считаю, что NullPointer говорит оо ошибке и маскировать это нельзя.
 * в любом случае, это имеет место, значит, есть смысл это описать.
 * Это работает для void методов реального объекта. но как быть с методами, возвращающими значение?
 */
package com.nahorny.pattern.behavioral.nullobject;

public class Client {
    public static void main(String[] args) {
        SomeObjectCanBeNull someObjectCanBeNull = new SomeObjectCanBeNull(0);
        //next line we will get NullPointerException if previous one we give negative argument
        someObjectCanBeNull.getInstance().printA();
    }
}
