/**
 * Element's interface
 * интерфейс элемента вхлдящего в структуру
 */
package com.nahorny.pattern.behavioral.visitor;

public interface Element {
    void beDone(Worker worker); // worker = visitor
}
