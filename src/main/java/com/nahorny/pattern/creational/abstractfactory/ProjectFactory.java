package com.nahorny.pattern.creational.abstractfactory;

public interface ProjectFactory {
    Designer getDesigner();
    Installer getInstaller();
    Commissioner getCommissioner();
}
