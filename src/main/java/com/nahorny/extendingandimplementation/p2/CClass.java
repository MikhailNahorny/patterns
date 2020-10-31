/**
 * ромбовидное наследование невозможно в Джава по причине отсутствия множественного наследия
 * однако проблема может возникнуть при реализации интерфейсов имеющих реализацию метода по умолчанию
 * тогда придется переопределить конфликтный метод
 */
package com.nahorny.extendingandimplementation.p2;

public class CClass implements InterA, InterB{
    //without overriding of public void method() we get compilation error
    //because both interfaces CClass implements has default method(){}
    @Override
    public void method() {
        System.out.println("conflict of default implementation have to be resolved by overriding method");
    }
}
