/**
 * Bridge is used to separate abstraction and implementation
 */
package com.nahorny.pattern.structural.bridge;

public class Client {
    public static void main(String[] args) {
        Building[] buildings = {
                new Hut(new Carpenter(), 10, 1),
                new Palace(new Bricklayer(), 100, 10),
                new Hut(new Bricklayer(), 10, 1),
                new Palace(new Carpenter(), 100, 10)
        };


        for (Building building : buildings){
            building.build();
        }

    }
}
