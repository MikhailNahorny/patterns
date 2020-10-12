package com.nahorny.pattern.creational.prototype;

public class Prototype implements Copyable{
private int id;
private String name;
private String type;

    public Prototype(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public Copyable copy() {
        return new Prototype(id, name, type);
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}' + " Hash:" + Integer.toHexString(this.hashCode());
    }
}
