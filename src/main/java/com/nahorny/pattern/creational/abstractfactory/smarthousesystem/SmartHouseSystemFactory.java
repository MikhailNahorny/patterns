package com.nahorny.pattern.creational.abstractfactory.smarthousesystem;

import com.nahorny.pattern.creational.abstractfactory.ProjectFactory;
import com.nahorny.pattern.creational.abstractfactory.Commissioner;
import com.nahorny.pattern.creational.abstractfactory.Designer;
import com.nahorny.pattern.creational.abstractfactory.Installer;

public class SmartHouseSystemFactory implements ProjectFactory {
    @Override
    public Designer getDesigner() {
        return new SmartHouseSystemDesigner();
    }

    @Override
    public Installer getInstaller() {
        return new SmartHouseSystemInstaller();
    }

    @Override
    public Commissioner getCommissioner() {
        return new SmartHouseSystemCommissioner();
    }
}
