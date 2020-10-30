/**
 * concrete visitor 2
 */
package com.nahorny.pattern.behavioral.visitor;

public class Carpenter implements Worker{
    @Override
    public void build(Hospital hospital) {
        System.out.println("build wooden hospital");
    }

    @Override
    public void build(Store store) {
        System.out.println("build wooden store");
    }

    @Override
    public void build(House house) {
        System.out.println("build wooden house");
    }
}
