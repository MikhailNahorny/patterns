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

        Bicycle bicycle = new Bicycle("MTB");
        bicycle.addPart("frame", 2000, 1.8f);
        bicycle.addPart("fork", 5000, 1.6f);
        bicycle.addPart("wheelSet", 4000, 2.8f);
        bicycle.addPart("seat", 100, 0.3f);
        //iterator usage for linked list based collection
        Iterator bicycleIterator = bicycle.getIterator();
        System.out.println("an " + bicycle.getType() + "-bicycle consist of:");
        while (bicycleIterator.hasNext()) {
            System.out.println(bicycleIterator.next());
        }
        System.out.println();

        TreeContainer treeContainer = new TreeContainer();
        for (int i = 0; i < 10; i++) {
            int toAdd = (int) (Math.random() * 100 * Math.sin(i));
            treeContainer.add(toAdd);
        }
        //iterator usage for binary tree based collection
        Iterator treeIterator = treeContainer.getIterator();
        System.out.print("given binary tree collection contains following random numbers: ");
        while (treeIterator.hasNext()) {
            System.out.print(treeIterator.next() + ", ");
        }
        System.out.println("\b\b\n");
    }
}
