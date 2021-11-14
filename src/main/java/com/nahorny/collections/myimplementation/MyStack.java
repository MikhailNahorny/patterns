package com.nahorny.collections.myimplementation;

import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack {
    private Node head, tail;
    private int size;

    public MyStack() {
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
        else throw new EmptyStackException();
        size--;
        return res.payload;
    }

    public Object peek() {
        return head.payload;
    }

    public boolean empty() {
        return size == 0;
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