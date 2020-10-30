/**
 * concrete visitor 1
 */
package com.nahorny.pattern.behavioral.visitor;

public class Bricklayer implements Worker{
    @Override
    public void build(Hospital hospital) {
        System.out.println("build brick hospital");
    }

    @Override
    public void build(Store store) {
        System.out.println("build brick store");
    }

    @Override
    public void build(House house) {
        System.out.println("build brick house");
    }
}
