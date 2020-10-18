/**
 * Decorator
 * позволяет динамически добавлять объектам функциональность, оборачивая их или изменять ее (переопределение)
 * декоратор реализует интерфейс базового объекта, а обертки наследуются от него
 *
 * в отличие от прокси
 * не умеет сам создавать базовый объект, а получает его в конструктор
 * не ограничивает доступ
 */

package com.nahorny.pattern.structural.decorator;

public class Client {
    public static void main(String[] args) {
        Worker worker = new Architect(new Foreman(new Bricklayer()));
        worker.justDoIt();
    }
}
