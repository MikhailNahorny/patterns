/**
 * Command
 * инкапсулирует запросы в объект, ослабляет связь между отправитилем и получателем запроса
 */
package com.nahorny.pattern.behavioral.command;

public class Client {
    public static void main(String[] args) {
        Automobile automobile = new Automobile();
        Driver driver = new Driver();

        driver.addCommand("start", new Start(automobile));
        driver.addCommand("stop", new Stop(automobile));
        driver.addCommand("speedUp", new SpeedUp(automobile));
        driver.addCommand("speedDown", new SpeedDown(automobile));

        driver.execute("start");
        driver.execute("speedUp");
        driver.execute("speedDown");
        driver.execute("stop");

    }

}
