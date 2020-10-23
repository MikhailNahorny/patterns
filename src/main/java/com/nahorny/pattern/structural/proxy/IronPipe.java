package com.nahorny.pattern.structural.proxy;

public class IronPipe implements Pipe {
    public IronPipe() {
        System.out.println("a pipe is a heavy object, its creation requires resources:");
        System.out.println("pipe purchase...");
        delay();
        System.out.println("pipe delivery...");
        delay();
        System.out.println("pipe installation...");
        delay();
        System.out.println("pipe inspection...");
    }

    @Override
    public void waterSupply() {
        System.out.println("water is present!");
    }

    /**
     * to demonstrate initialization of heavy object
     */
    void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
