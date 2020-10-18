/**
 * в нашем примере - базовый класс, который будем оборачивать
 */
package com.nahorny.pattern.structural.decorator;

public class Bricklayer implements Worker {
    @Override
    public void justDoIt() {
        System.out.println("building the building");
    }
}
