/**
 * интерфейс объектка, который нуждается в посредничестве. применен именно абстракный класс для того, чтобы иметь возможность хранить непубличные поля
 */

package com.nahorny.pattern.behavioral.mediator;

public abstract class Worker {
    private Mediator mediator;

    public Worker(Mediator director) {
        this.mediator = director;
    }

    public void send (String message){
        mediator.send(message, this);
    }

    public abstract void receive(String message);
}
