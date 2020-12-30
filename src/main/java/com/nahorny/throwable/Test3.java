package com.nahorny.throwable;

public class Test3 {
    public static void main(String[] args) {
        try {
            throw new IllegalArgumentException("ex 1");
        } catch (RuntimeException s) {
            System.out.println("catch 1");
            throw new RuntimeException("ex 2");
        } finally {
            System.out.println("finally 1");
            throw new RuntimeException("ex 3");
        }
    }
}
