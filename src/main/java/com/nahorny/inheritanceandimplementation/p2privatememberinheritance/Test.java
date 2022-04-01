/*
 * здесь поговорим о разнице между абстрактным классом и нтерфейсом
 * 1. единичное наследование, множественная реализация
 * 2. поля класа могут быть не static, не public и не final, у интерфейса все поля ТОЛЬКО public static final
 * 3. класс может реализовывать методы, интерфейс - нет, но стоит сказать и default реализациях, которые появились с V1.8
 * 4. исходя из п.2 интерфейс не может иметь состояний (переменные), только константы и не может иметь private методов. абстрактный класс может
 * <p>
 * diamond problem - see CClass
 * <p>
 * наследование приватных членов.
 * AClass имеет  private int x. есть ли это поле в объекте класса BClass? да, есть. это можно увидеть отладчике
 * как получить доступ к этому полю в BClass? public int getX() наследуется в BClass и может быть вызван.
 * что именно вернет public int getX() в BClass? значение поля. если оно не было определено, то по умочанию.
 */

package com.nahorny.inheritanceandimplementation.p2privatememberinheritance;

public class Test {
    public static void main(String[] args) {
        AClass aClass = new AClass();
        BClass bClass = new BClass();
        //the result is obvious
        aClass.method();
        bClass.method();

        BClass bClass1 = new BClass();
        bClass1.method();
        bClass1.newMethod();
        AClass aClass1 = bClass1;
        aClass1.method();
        //строка ниже не скомпилируется потому что мы положили класс-наследник по ссылке родительского класса,
        //а значит и работать с ним должны как с родительским. проще говоря, если из ведра перелить в чашку,
        //то все, что в чашку не влезло, потеряется.
        //aClass1.newMethod();
        // в отличие от примера из жизни, мы еще можем вернуть все содержимое ведра
        //для этого нужно присвоиться ссылке ведра с кастованием к ведру.
        BClass bClass2 = (BClass) aClass1;
        bClass2.method();
        bClass2.newMethod();

        System.out.println(aClass.getX());
        System.out.println(bClass.getX());
        bClass.setX(5);
        System.out.println(aClass.getX());
        System.out.println(bClass.getX());
    }
}
