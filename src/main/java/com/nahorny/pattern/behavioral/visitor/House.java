/**
 * реализация конкретного элемента 3
 */
package com.nahorny.pattern.behavioral.visitor;

public class House implements Element{
    @Override
    public void beDone(Worker worker) {
        worker.build(this);
    }
}
