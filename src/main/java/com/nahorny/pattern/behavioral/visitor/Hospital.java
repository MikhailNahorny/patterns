/**
 * реализация конкретного элемента 1
 */
package com.nahorny.pattern.behavioral.visitor;

public class Hospital implements Element{
    @Override
    public void beDone(Worker worker) {
        worker.build(this);
    }
}
