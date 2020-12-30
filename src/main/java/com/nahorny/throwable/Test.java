/*
здесь рассмотрим исключения.
полезные ссылки:
https://habr.com/ru/company/golovachcourses/blog/223821/
https://habr.com/ru/company/golovachcourses/blog/225585/
https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html
 */
package com.nahorny.throwable;

public class Test {
    public static void main(String[] args) {
        divisionEx(1);
        delay(5000);
    }

    public static void divisionEx(int a, int b) {
        /*если b == 0, то в строке ниже будет брошено исключение java.lang.ArithmeticException: / by zero
        это unchecked exception потому компилятор не требует его обработать
         */
        System.out.println(a / b);
    }

    public static void divisionEx(int a) {
        /*
        try-catch-finally
        блок try обязателен, остальные блоки - в любых вырициях
        для множественных catch ловить нужно от нижнего к верхнему в иерархии
         */
        try {
            Object o = null;
            //o.toString();
            //System.out.println(a / 0);
        } catch (ArithmeticException s) {
            System.out.println("пытались поделить на ноль, но ничего не взорвалось");
        } catch (NullPointerException s) {
            System.out.println("пытались вызвать метод у нулл, но ничего не взорвалось");
        } catch (RuntimeException s) {
            System.out.println("ArithmeticException и NullPointerException ниже RuntimeException в иерархии классов, потому их нельзя ловить после RuntimeException");
        } catch (Exception s) {
            System.out.println("Exception выше RuntimeException, так что если попвтаться ловить его до RuntimeException, компилятор выдаст ошибку");
        } finally {
            System.out.println("независимо от того, взорвалось что-то или нет, эта часть выполнится. в любом случае*");
            /*
            * за исключением случаев ниже:
            1.	System.exit(exitCode);
            2.	сбой JVM
            3.	try{while(true){}}
            4.	ОС завершит процесс JVM
            5.	смерть хоста
            6.	kernel panic
            7.	finally выполняется в потоке-демоне и все потоки не-демоны завершились
             */
        }

    }//method

    public static void delay(int millis){
        try{
            /*
            Thread.sleep() бросит исключение если у потока был вызван метод interrupt()
            это проверяемое исключение, так что его нужно проверить или пробросить выше (добавить в сигнатуру метода)
             */
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}//class
