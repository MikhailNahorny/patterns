package com.nahorny.pattern.creational.abstractfactory.smarthousesystem;

import com.nahorny.pattern.creational.abstractfactory.Commissioner;

public class SmartHouseSystemCommissioner implements Commissioner {
    @Override
    public void performCommissioning() {
        System.out.println("Commissioning engineer perform commissioning of SmartHouseSystem");
    }
}
