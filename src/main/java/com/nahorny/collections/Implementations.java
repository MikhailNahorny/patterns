/**
 * let's list implementations of Java collections
 * https://docs.oracle.com/javase/tutorial/collections/implementations/summary.html
 * see also static classes  Arrays,  Collections
 */
package com.nahorny.collections;

import java.util.*;

public class Implementations {
    final static String FIRST = "first";

    public static void main(String[] args) {
        Set<String> setImp;
        setImp = new TreeSet<>();
        setImp = new HashSet<>();
        setImp = new LinkedHashSet<>();
        setImp.add(FIRST);

        List<String> listImp;
        listImp= new ArrayList();
        listImp = new LinkedList<>();

        Map<String, Object> mapImp;
        mapImp = new TreeMap<>();
        mapImp = new LinkedHashMap<>();
        mapImp = new HashMap<>();
        mapImp.put(FIRST, new Object());

        Queue<String> queueImp;
        queueImp = new PriorityQueue(); // Deque extends Queue, therefore LinkedList & ArrayDeque too

        Deque<String> dequeImp;
        dequeImp = new LinkedList<>();
        dequeImp = new ArrayDeque<>();
        dequeImp.add(FIRST);
    }
}
