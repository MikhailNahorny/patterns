package com.nahorny.pattern.creational.abstractfactory.electronics;

import com.nahorny.pattern.creational.abstractfactory.Commissioner;

public class ElectronicsCommissioner implements Commissioner {
    @Override
    public void performCommissioning() {
        System.out.println("Commissioning engineer perform commissioning of Electronics");
    }
}
