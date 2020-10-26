/**
 * метод getInstance() возвращает объект или нулл
 */
package com.nahorny.pattern.behavioral.nullobject;

public class SomeObjectCanBeNull {
    int a;

    public SomeObjectCanBeNull(int a) {
        this.a = a;
    }

    public void printA() {
        System.out.println(a);
    }

    public SomeObjectCanBeNull getInstance(){
        //return (a > 0) ? new SomeObjectCanBeNull(a - 1) : null;
        //lets return NullObject instead of null
        return (a > 0) ? new SomeObjectCanBeNull(a - 1) : new NullSomeObjectCanBeNull(1);
    }
}
