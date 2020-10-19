package com.nahorny.pattern.structural.composite;

import java.util.LinkedList;
import java.util.List;

public class Foreman implements Worker {
    private String teemName;
    private List<Worker> teem = new LinkedList<>();

    public Foreman(String teemName) {
        this.teemName = teemName;
    }

    public void addWorker(Worker worker) {
        teem.add(worker);
    }

    @Override
    public void doWork() {
        System.out.println(teemName + " start work:");
        teem.forEach(Worker::doWork);
    }
}
