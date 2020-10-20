/**
 * получатель команды
 */

package com.nahorny.pattern.behavioral.command;

public class Automobile {
    public void start() {
        System.out.println("engin started");
    }

    public void stop() {
        System.out.println("engin stopped");
    }

    public void acceleration() {
        System.out.println("automobile increase speed");
    }

    public void deceleration() {
        System.out.println("automobile decrease speed");
    }

}
