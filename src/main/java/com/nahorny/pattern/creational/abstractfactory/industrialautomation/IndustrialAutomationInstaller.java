package com.nahorny.pattern.creational.abstractfactory.industrialautomation;

import com.nahorny.pattern.creational.abstractfactory.Installer;

public class IndustrialAutomationInstaller implements Installer {
    @Override
    public void performInstallation() {
        System.out.println("Installer perform installation of Industrial Automation");
    }
}
