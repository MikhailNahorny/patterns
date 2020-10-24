/**
 * интерфейс посредника. выделение интерфейса позволяет подменить конкретного посредника на другого (для измениния логики посредничества)
 */
package com.nahorny.pattern.behavioral.mediator;

public abstract class Mediator {
    public abstract void send(String message, Worker worker);
}
