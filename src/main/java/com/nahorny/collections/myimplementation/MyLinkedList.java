package com.nahorny.collections.myimplementation;

import java.util.*;

public class MyLinkedList implements List {
    private Node head, tail;
    private int size = 0;

    public MyLinkedList() {
    }

    //List contract
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
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

//            @Override //not necessary to implement default method
//            public void remove() {
//                throw new UnsupportedOperationException("Remove not implemented.");
//            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            res[i] = current.payload;
            current = current.next;
        }
        return res;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        if (objects.length >= this.toArray().length) {
            objects = this.toArray();
            return objects;
        } else throw new IndexOutOfBoundsException("overflow");
    }

    @Override
    public boolean add(Object o) {
        if (this.isEmpty()) {
            this.linkToEmptyList(new Node(null, o));
        } else {
            linkAfter(tail, o);
        }

        return true;
    }

    @Override
    public void add(int index, Object o) {
        checkIndex(index);
        linkAfter(getNode(index), o);
    }

    @Override
    public void clear() {
        Node next = null;
        for (Node current = head; current != null; next = current.next) {
            current.payload = current.next = current.prev = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return getNode(index);
    }

    @Override
    public Object set(int index, Object o) {
        checkIndex(index);
        Node modified = getNode(index);
        Object oldValue = modified.payload;
        modified.payload = o;
        return oldValue;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        return unlink(getNode(index));
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) return false;
        Node current = head;

        while (current != null) {

            if (current.payload.equals(o)) {
                return unlink(current) == o;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        boolean res = false;
        if (collection == null) return false;
        for (Object o : collection) {
            this.add(o);
            res = true;
        }
        return res;
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        boolean res = false;
        checkIndex(index);
        for (Object o : collection) {
            this.add(index++, o);
            res = true;
        }
        return res;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            if (o.equals(current.payload)) return index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        for (Node current = tail; current != null; current = current.prev) {
            if (o.equals(current.payload)) return index;
        }
        return -1;
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
        if (collection == null) return false;
        boolean res = false;
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
        if (collection == null) return false;
        boolean res = false;
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

    //list contract end

    //Queue/Deque/Stack methods

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
        else throw new EmptyStackException();
        size--;
        return res.payload;
    }

    public Object peek() {
        return head.payload;
    }

    //Queue/Deque/Stack methods end

    //helpers

    private void checkIndex(int index) {
        if (!isIndexOK(index)) throw new IndexOutOfBoundsException("no such index");
    }

    private boolean isIndexOK(int index) {
        return index >= 0 && index < size;
    }

    private Node getNode(int index) {
        Node current;
        if (index < (size / 2)) {
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--)
                current = current.prev;
        }
        return current;
    }

    private Object unlink(Node toUnlink) {
        Node prevNode = toUnlink.prev;
        Node nextNode = toUnlink.next;
        if (prevNode == null) {
            head = toUnlink.next;
        } else {
            prevNode.next = nextNode;
        }
        if (nextNode == null) {
            tail = toUnlink.prev;
        } else {
            nextNode.prev = prevNode;
        }
        size--;
        return toUnlink.payload;
    }

    private void linkAfter(Node previous, Object payload) {
        if (previous == null) throw new IllegalArgumentException();
        Node prevNode = previous;
        Node nextNode = previous.next;
        Node newNode = new Node(prevNode, payload, nextNode);
        prevNode.next = newNode;
        if (nextNode == null) {
            tail = newNode;
        } else {
            nextNode.prev = newNode;
        }
        size++;
    }

    private void linkBefore(Node before, Object payload) {
        if (before == null) throw new IllegalArgumentException();
        Node prevNode = before.prev;
        Node nextNode = before;
        final Node newNode = new Node(prevNode, payload, nextNode);
        nextNode.prev = newNode;
        if (prevNode == null) {
            head = newNode;
        } else {
            prevNode.next = newNode;
        }
        size++;
    }

    private void linkToEmptyList(Node first) {
        tail = head = first;
        size = 1;
    }

    //helpers end

    public class Node {
        private Object payload;
        private Node prev, next;

        Node(Object payload, Node next) {
            this.payload = payload;
            this.next = next;
        }

        Node(Node prev, Object payload) {
            this.payload = payload;
            this.prev = prev;
        }

        Node(Node prev, Object payload, Node next) {
            this.payload = payload;
            this.next = next;
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
}