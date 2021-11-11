package com.nahorny.collections.myimplementation;

import java.util.List;
import java.util.ListIterator;

public class MyArrayListTest {
    public static void main(String[] args) {
        //init collections
        MyArrayList col = new MyArrayList();
        Car car1 = new Car("Reno", "Logan", 2019, "grey", true, 15000);
        Car car2 = new Car("Nissan", "Patrol", 2010, "black", false, 25000);
        Car car3 = new Car("Toyota", "Mark2", 1980, "white", true, 700);
        Car car4 = new Car("Nissan", "Patrol", 2010, "black", false, 25000);
        Car car5 = new Car("Reno", "Megane", 0, "grey", true, 35000);
        col.add(car1);
        col.add(car2);
        col.add(car3);
        col.add(car4);
        col.add(car5);

        MyArrayList col2 = new MyArrayList();
        Car car6 = new Car("Жигули", "Копейка", 1970, "grey", true, 150);
        Car car7 = new Car("Москвич", "412", 1965, "grey", true, 150);
        Car car8 = new Car("Волга", "21", 1975, "grey", true, 150);

        col2.add(car6);
        col2.add(car7);
        col2.add(car8);


//        System.out.println("collection 1:");
//        System.out.println(col);
//        System.out.println("collection 1 size: " + col.size());
//        System.out.println();
//        System.out.println("collection 2:");
//        System.out.println(col2);
//        System.out.println("collection 2 size: " + col2.size());
//        System.out.println();
        //init collections


        col.sort(Car.ByPrice);
        System.out.println("sorted ByPrice: \n" + col);

        col.sort(Car.ByYear);
        System.out.println("sorted ByYear: \n" + col2);


        System.out.println("remove(1) expect {" + car2 + "}: " + "{" + col.remove(1) + "}");
        System.out.println(col);
        System.out.println("size, expect 3: " + col.size());
        System.out.println();

        System.out.println("indexOf : " + col.indexOf(car2));
        System.out.println("lastIndexOf : " + col.lastIndexOf(car5));

        System.out.println("instead {" + col2.set(1, car5) + "} expect {" + car5 + "}");
        System.out.println(col2);
        System.out.println(col.get(2));


        //addAll
        System.out.println("addAll(1, coll2) expect true: " + col.addAll(1, col2));
        System.out.println("new entities:\n" + col);
        System.out.println("summed size: " + col.size());

        System.out.println();

        {
            System.out.println("------------------------------------check iterator:\n");
            ListIterator it = col.listIterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println("nextIndex: " + it.nextIndex());
            System.out.println("---назад");
            while (it.hasPrevious()) {
                System.out.println(it.previous());
            }

            System.out.println("nextIndex: " + it.nextIndex());
            System.out.println("---еще разок вперед, удалим:");
            System.out.println(it.next());
            System.out.println(it.next());
            System.out.println("этого удалим: " + it.next());
            it.remove();
            System.out.println(it.next());
            System.out.println("этого перетрем пустым объектом: " + it.next());
            it.set(new Object());
            System.out.println("после этого вставим что-то новое: " + it.next());
            it.add("что-то новое");
            System.out.println(it.next());

            System.out.println("---назад");
            while (it.hasPrevious()) {
                System.out.println(it.previous());
            }
            System.out.println("---вперед");
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println("------------------------------------check iterator\n");
        }

        List<String> subList = col2.subList(2, 4);
        System.out.println(subList.size());
    }//main
}//ToTest

