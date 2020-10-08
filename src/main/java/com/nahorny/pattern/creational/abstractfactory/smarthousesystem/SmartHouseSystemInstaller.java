package com.nahorny.pattern.creational.abstractfactory.smarthousesystem;


import com.nahorny.pattern.creational.abstractfactory.Installer;

public class SmartHouseSystemInstaller implements Installer {
    @Override
    public void performInstallation() {
        System.out.println("Installer perform installation of SmartHouseSystem");
    }
}
