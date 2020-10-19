package com.nahorny.pattern.structural.composite;

import java.util.LinkedList;
import java.util.List;

public class ConstructionDirector implements Worker {
    private String projectName;
    private List<Worker> foremen = new LinkedList<>();

    public ConstructionDirector(String projectName) {
        this.projectName = projectName;
    }

    public void addWorker(Foreman foreman) {
        foremen.add(foreman);
    }

    @Override
    public void doWork() {
        System.out.println("\"" + projectName + "\" project in progress...");
        foremen.forEach(Worker::doWork);
    }
}
