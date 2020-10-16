/**
 * Iterator
 * позволяет последовательно обходить элементы коллекции не раскрывая внутреннее устройство
 */
package com.nahorny.pattern.behavioral.iterator;

public class Client {
    public static void main(String[] args) {
        Cat cat = new Cat("Vasilisa", new String[]{"eat", "drink", "sleep", "play"});
        //iterator usage for array based collection
        Iterator catIterator = cat.getIterator();
        System.out.println();
        System.out.print(cat.getName() + "-cat can perform following actions: ");
        while (catIterator.hasNext()) {
            System.out.print(catIterator.next() + ", ");
        }
        System.out.println("\b\b\n");
    }
}
