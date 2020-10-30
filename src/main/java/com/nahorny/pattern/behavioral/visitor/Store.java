/**
 * реализация конкретного элемента 2
 */
package com.nahorny.pattern.behavioral.visitor;

public class Store implements Element {
    @Override
    public void beDone(Worker worker) {
        worker.build(this);
    }
}
