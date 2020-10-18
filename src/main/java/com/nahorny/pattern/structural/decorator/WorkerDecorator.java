/**
 * класс декоратора реализует интерфейс базового класса
 */
package com.nahorny.pattern.structural.decorator;

public class WorkerDecorator implements Worker {
    Worker worker;

    public WorkerDecorator(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void justDoIt() {
        worker.justDoIt();
    }
}
