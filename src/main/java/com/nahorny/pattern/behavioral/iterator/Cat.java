/**
 * array based collection
 */

package com.nahorny.pattern.behavioral.iterator;

public class Cat implements Collection{
    public String getName() {
        return name;
    }

    private String name;
    private String [] actions;

    public Cat(String name, String[] actions) {
        this.name = name;
        this.actions = actions;
    }

    @Override
    public Iterator getIterator() {
        return new Catirator();
    }

    private class Catirator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            return index < actions.length;
        }

        @Override
        public Object next() {
            return actions[index++];
        }
    }
}
