package com.nahorny.pattern.creational.abstractfactory.electronics;


import com.nahorny.pattern.creational.abstractfactory.Designer;

public class ElectronicsDesigner implements Designer {
    @Override
    public void createProject() {
        System.out.println("Designer perform project of Electronics");
    }
}
