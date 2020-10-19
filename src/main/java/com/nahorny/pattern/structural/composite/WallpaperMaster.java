package com.nahorny.pattern.structural.composite;

public class WallpaperMaster implements Worker {
    @Override
    public void doWork() {
        System.out.println("WallpaperMaster do his job");
    }
}
