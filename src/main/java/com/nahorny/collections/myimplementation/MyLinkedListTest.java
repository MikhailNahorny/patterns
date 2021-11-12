package com.nahorny.collections.myimplementation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class MyLinkedListTest {

    @Test
    public void testStack() {
        MyLinkedList st = new MyLinkedList();
        for (int i = 0; i <= 6; st.push(i++)) {
        }
        Assert.assertEquals(st.toString(), "[6, 5, 4, 3, 2, 1, 0]");
        Assert.assertEquals(st.peek(), 6);
        Assert.assertEquals(st.toString(), "[6, 5, 4, 3, 2, 1, 0]");
        Assert.assertEquals(st.pop(), 6);
        Assert.assertEquals(st.toString(), "[5, 4, 3, 2, 1, 0]");
        for (int i = 5; i >= 1; st.pop(), i--) {
        }
        Assert.assertEquals(st.pop(), 0);
        boolean emptyStackExceptionOK = false;
        try {
            st.pop();
        } catch (EmptyStackException e) {
            emptyStackExceptionOK = true;
        }
        Assert.assertTrue(emptyStackExceptionOK);
    }

    @Test
    public void testList() {
        MyLinkedList ll = new MyLinkedList();

        Assert.assertTrue(ll.isEmpty());
        ll.add(1);
        Assert.assertEquals(ll.size(), 1);
        Assert.assertFalse(ll.isEmpty());

        ll.add(2);
        ll.add(3);
        Assert.assertEquals(ll.size(), 3);


        for (int i = 4; i <= 20; ll.add(i++)) {
        }

        System.out.print("iterator test ");
        String allEntitiesExp = ll.toString();
        String allEntitiesIterator = "[";
        Iterator it = ll.iterator();
        while (it.hasNext()) {
            allEntitiesIterator += it.next() + ", ";
        }
        allEntitiesIterator = allEntitiesIterator.substring(0, allEntitiesIterator.length() - 2) + "]";
        Assert.assertEquals(allEntitiesIterator, allEntitiesExp, "iterator err");
        System.out.println(" ok");

        Object toRemove = 20;
        System.out.println("before deletion: " + ll);
        Assert.assertTrue(ll.remove(toRemove));
        Assert.assertFalse(ll.remove((Object) 245));
        System.out.println("after deletion " + toRemove + "-th: " + ll);
        Assert.assertFalse(ll.contains(25));

        MyLinkedList other = new MyLinkedList();
        other.add(11);
        other.add(21);
        other.add(31);
        System.out.println("another stack: " + other);
        ll.addAll(other);
        System.out.println("first stack after add another one: " + ll);

        Assert.assertTrue(ll.containsAll(other));
        other.add(41);
        Assert.assertFalse(ll.containsAll(other));


        System.out.println("стек до ретейнОлл: " + ll);
        System.out.println("другой до ретейнОлл: " + other);

        System.out.println("проверяем ремувОлл, ждем правду: " + ll.removeAll(other));
        System.out.println("после ремувОлл, ждем все, кроме 11, 21, 31: " + ll);

        Object[] ob = ll.toArray();
        System.out.println("stack.toArray()--------------(см стр выше): " + Arrays.toString(ob));
    }
}
