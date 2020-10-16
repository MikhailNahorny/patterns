/**
 * linked list based collection
 */

package com.nahorny.pattern.behavioral.iterator;

public class Bicycle implements Collection {
    private Part parts;
    private String type;

    public String getType() {
        return type;
    }

    public Bicycle(String type) {
        this.type = type;
    }

    public void addPart(String name, int price, float weight) {
        Part newPart = new Part(name, price, weight);
        if (parts == null) {
            parts = newPart;
        } else {
            Part current = parts;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPart;
        }

    }

    @Override
    public Iterator getIterator() {
        return new Iterator() {
                Part index;
            {
                index = parts;
            }


            @Override
            public boolean hasNext() {
                return index != null;
            }

            @Override
            public Object next() {
                Part current = index;
                index = index.next;
                return current;
            }
        };
    }

    private class Part {
        Part next;
        String name;
        int price;
        float weight;

        public Part(String name, int price, float weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "['" + name + '\'' + ", price=" + price + ", weight=" + weight + ']';
        }
    }
}
