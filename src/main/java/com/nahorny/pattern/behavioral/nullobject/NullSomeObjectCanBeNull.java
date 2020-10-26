/**
 * Object to be returned instead of null
 * It's extends real object
 */
package com.nahorny.pattern.behavioral.nullobject;

public class NullSomeObjectCanBeNull extends SomeObjectCanBeNull {
    public NullSomeObjectCanBeNull(int a) {
        super(a);
    }

    @Override
    public void printA() {
        //do nothing
    }
}
