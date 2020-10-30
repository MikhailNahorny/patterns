/**
 * Visitor. шаблон использует двойную диспетчеризацию
 * позволяет разместить новое поведение в отдельном классе, не изменяя поведение в каждого класса
 * описывет операцию, которая выполняется над объектами других классов, эта операция зависит от конкретного класса
 *
 */
package com.nahorny.pattern.behavioral.visitor;

public class Client {
    public static void main(String[] args) {
        City city = new City();
        Worker bricklayer = new Bricklayer();
        Worker carpenter = new Carpenter();
        System.out.println("\nCarpenter");
        city.beDone(carpenter);
        System.out.println("\nBricklayer");
        city.beDone(bricklayer);
    }
}
