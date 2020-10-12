package com.nahorny.pattern.creational.prototype;

public class Factory {
    Prototype prototype;

    public Factory(Prototype prototype) {
        this.prototype = prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }

    Prototype clonePrototype(){
        return (Prototype) prototype.copy();
    }
}
