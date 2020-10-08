package com.nahorny.pattern.creational.abstractfactory.smarthousesystem;

import com.nahorny.pattern.creational.abstractfactory.Designer;

public class SmartHouseSystemDesigner implements Designer {
    @Override
    public void createProject() {
        System.out.println("Designer perform project of SmartHouseSystem");
    }
}
