package com.nahorny.inheritanceandimplementation.p4abstractclassinstance;
/*
абстрактный класс, реализующий интерфейс не обязан реализовывать его методы
но конкретный класс, наследующий этот класс, должен реализовать все абстрактные методы абс класса + интерфейса
 */
public abstract class Abs implements Inter {
    protected static String s = "static abs class string";
    protected String s2 = "non-static abs class string";

}
