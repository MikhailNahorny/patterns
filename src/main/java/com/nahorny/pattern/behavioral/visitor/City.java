/**
 * некая структура, в которую входят классы Hospital, Store, House
 */
package com.nahorny.pattern.behavioral.visitor;

public class City implements Element{
    Element[] elements;

    public City() {
        this.elements = new Element[]{
                new Hospital(),
                new House(),
                new Store()
        };
    }

    @Override
    public void beDone(Worker worker) {
        for (Element element : elements) {
            element.beDone(worker);
        }
    }
}
