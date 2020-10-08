package com.nahorny.pattern.creational.abstractfactory.industrialautomation;

import com.nahorny.pattern.creational.abstractfactory.Commissioner;

public class IndustrialAutomationCommissioner implements Commissioner {
    @Override
    public void performCommissioning() {
        System.out.println("Commissioning engineer perform commissioning of Industrial Automation");
    }
}
