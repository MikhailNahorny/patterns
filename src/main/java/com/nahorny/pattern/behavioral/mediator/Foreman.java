/**
 * реализация посредника
 */
package com.nahorny.pattern.behavioral.mediator;

public class Foreman extends Mediator {
    private Bricklayer bricklayer;
    private Carpenter carpenter;

    public void setBricklayer(Bricklayer bricklayer) {
        this.bricklayer = bricklayer;
    }

    public void setCarpenter(Carpenter carpenter) {
        this.carpenter = carpenter;
    }

    @Override
    public void send(String message, Worker worker) {
        if (worker.equals(bricklayer)) {
            carpenter.receive(message);
        } else {
            bricklayer.receive(message);
        }
    }
}
