/**
 * реализация объектка, который нуждается в посредничестве
 */
package com.nahorny.pattern.behavioral.mediator;

public class Carpenter extends Worker {
    public Carpenter(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("Carpenter receive: " + message);
    }
}
