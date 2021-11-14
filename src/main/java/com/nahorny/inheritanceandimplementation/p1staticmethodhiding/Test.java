/**
 * переопределение статического метода невозможно, но сокрытие возможно
 * переопределение статического поля невозможно - см BClass
 *
 */

package com.nahorny.inheritanceandimplementation.p1staticmethodhiding;

public class Test {
    public static void main(String[] args) {
        AClass aClass = new AClass();
        System.out.println("AClass not static field = " + aClass.getA());
        System.out.println("AClass static field = " + AClass.getB());

        BClass bClass = new BClass();
        System.out.println("BClass not static field = " + bClass.getA());
        System.out.println("BClass static field = " + BClass.getB());
        System.out.println("BClass static field = " + BClass.b);

        System.out.println("CClass static field via hidden getter = " + CClass.getB());
    }
}
