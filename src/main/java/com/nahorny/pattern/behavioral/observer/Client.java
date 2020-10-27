/**
 * Observer, издатель-подписчик
 * структура - интерфейс подписчика, подписчики, издатель, иногда его интерсейс (реализуя который можно любой объект сделать издателем)
 *
 * в нашем примере охранная система и климат-контроль слушают умный дом и метеостанцию
 * дом говорит пришел-ушел жилец и пора спать-просыпаться
 * метеостанция говорит температуру и скорость ее изменения (последнее оправдывает опрос метеостанции в принципе, но реализовывать не будем)
 * охрана становится на охрану по уходу жильца
 * климатконтроль реагирует на присутствие-отсутствие жильца и время сна-бодрствования и температуру за бортом и ее изменение
 */
package com.nahorny.pattern.behavioral.observer;

public class Client {
    public static void main(String[] args) {
        SmartHouseSystem smartHouseSystem = new SmartHouseSystem();
        WeatherStation weatherStation = new WeatherStation();

        Observer climateControlSystem = new ClimateControlSystem();
        Observer securitySystem = new SecuritySystem();

        smartHouseSystem.registerObserver(climateControlSystem);
        smartHouseSystem.registerObserver(securitySystem);
        weatherStation.registerObserver(climateControlSystem);

        smartHouseSystem.updateData("first person came");
        smartHouseSystem.notifyObservers();

        weatherStation.updateData("the weather is getting more comfortable");
        weatherStation.notifyObservers();

    }
}

/*
data for smartHouseSystem.updateData()
first person came
the last person left
time to wake up
time to sleep

data for weatherStation.updateData()
the weather is becoming less comfortable
the weather is getting more comfortable
 */
