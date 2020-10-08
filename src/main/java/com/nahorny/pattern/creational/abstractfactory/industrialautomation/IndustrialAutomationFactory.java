package com.nahorny.pattern.creational.abstractfactory.industrialautomation;

import com.nahorny.pattern.creational.abstractfactory.Commissioner;
import com.nahorny.pattern.creational.abstractfactory.Designer;
import com.nahorny.pattern.creational.abstractfactory.Installer;
import com.nahorny.pattern.creational.abstractfactory.ProjectFactory;

public class IndustrialAutomationFactory implements ProjectFactory {
    @Override
    public Designer getDesigner() {
        return new IndustrialAutomationDesigner();
    }

    @Override
    public Installer getInstaller() {
        return new IndustrialAutomationInstaller();
    }

    @Override
    public Commissioner getCommissioner() {
        return new IndustrialAutomationCommissioner();
    }
}
