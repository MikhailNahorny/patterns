package com.nahorny.collections.myimplementation;

import java.util.*;

public class MyLinkedList implements List {
    private Node head, tail;
    private int size;

    public MyLinkedList() {
    }

    public boolean push(Object o) {
        if (o == null) return false;
        Node prevHead = head;
        head = new Node(o, head);

        if (size == 0) {
            tail = head;
        } else {
            prevHead.prev = head;
        }

        size++;
        return true;
    }

    public Object pop() {
        Node res = head;
        if (head != null) head = head.next;
        else throw new IndexOutOfBoundsException("empty");
        size--;
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        Node current = head;
        while (current != null) {
            res += current.payload + ", ";
            current = current.next;
        }
        return '[' + ((!res.isEmpty()) ? res.substring(0, res.length() - 2) : "") + ']';
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }//or size == 0;

    @Override
    public boolean contains(Object o) {
        if (o == null) return false;
        Node current = head;
        while (current != null) {
            if (current.payload.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    Object data = current.payload;
                    current = current.next;
                    return data;
                }
                return null;
            }

//            @Override
//            public void remove() {
//                throw new UnsupportedOperationException("Remove not implemented.");
//            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[this.size];
        Node current = this.head;
        for (int i = 0; i < this.size; i++) {
            res[i] = current.payload;
            current = current.next;
        }

        return res;
    }

    @Override
    public boolean add(Object o) {
        if (o == null) return false;
        if (head == null) {
            this.push(o);
        } else {
            Node toAdd = new Node(tail, o);
            tail.next =toAdd;
            toAdd.prev = tail;
            tail = toAdd;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) return false;
        Node current = head;

        while (current != null) {

            if (current.payload.equals(o)) {
                return delete(current);
            } else {
                current = current.next;
            }
        }
        return false;
    }

    private boolean delete(Node current) {
        Node pr = current.prev;
        Node nx = current.next;
        if (pr != null) {
            pr.next = nx;
        } else {
            if (current == head) head = head.next;
        }
        if (nx != null) {
            nx.prev = pr;
        }
        this.size--;
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        boolean res = false;
        if (collection == null) return res;
        for (Object o : collection) {
            this.add(o);
            res = true;
        }
        return res;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() {
        this.tail = this.head = null;
        this.size = 0;
    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public Object set(int i, Object o) {
        return null;
    }

    @Override
    public void add(int i, Object o) {
    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean retainAll(Collection collection) {
        boolean res = false;
        if (collection == null) return res;
        for (Object o : this) {
            if (!collection.contains(o)) {
                this.remove(o);
                res = true;
            }
        }
        return res;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean res = false;
        if (collection == null) return res;
        for (Object o : this) {
            if (collection.contains(o)) {
                this.remove(o);
                res = true;
            }
        }
        return res;
    }

    @Override
    public boolean containsAll(Collection collection) {
        if (collection == null) return false;
        for (Object o : collection) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        if (objects.length >= this.toArray().length) {
            objects = this.toArray();
            return objects;
        } else throw new IndexOutOfBoundsException("overflow");
    }

    public class Node {
        private Object payload;
        private Node prev, next;

        public Node(Object payload, Node next) {
            this.payload = payload;
            this.next = next;
        }

        public Node(Node prev, Object payload) {
            this.payload = payload;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "[node.payload:" + payload + ']';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return payload.equals(node.payload);
        }

        @Override
        public int hashCode() {
            return Objects.hash(payload);
        }
    }
}
