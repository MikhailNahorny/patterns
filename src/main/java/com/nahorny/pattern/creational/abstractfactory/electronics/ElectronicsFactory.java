package com.nahorny.pattern.creational.abstractfactory.electronics;

import com.nahorny.pattern.creational.abstractfactory.Designer;
import com.nahorny.pattern.creational.abstractfactory.Commissioner;
import com.nahorny.pattern.creational.abstractfactory.Installer;
import com.nahorny.pattern.creational.abstractfactory.ProjectFactory;

public class ElectronicsFactory implements ProjectFactory {
    @Override
    public Designer getDesigner() {
        return new ElectronicsDesigner();
    }

    @Override
    public Installer getInstaller() {
        return new ElectronicsInstaller();
    }

    @Override
    public Commissioner getCommissioner() {
        return new ElectronicsCommissioner();
    }
}
