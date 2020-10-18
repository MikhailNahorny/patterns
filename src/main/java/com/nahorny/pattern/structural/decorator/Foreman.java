/**
 * обертка, добавляющаяя функционал
 */
package com.nahorny.pattern.structural.decorator;

public class Foreman extends WorkerDecorator {
    public Foreman(Worker worker) {
        super(worker);
    }

    public void manage(){
        System.out.println("managing of workers");
    }

    @Override
    public void justDoIt() {
        manage();
        super.justDoIt();
    }
}
