/**
 * Паттерн Facade определяет для подсистемы интерфейс высокого уровня, упрощает работу с системой
 * позволяет получить результат вызывая один метод одного класса вмместо множества вызовов разных методов разных классав
 * пример из жизни - кафе, официант и все остальное
 * очевидно, что взаиммодействие подсистем может быть много сложнее, чем в примере, но дял понимания паттерна приведенного кода хватает
 */

package com.nahorny.pattern.structural.facade;

public class CoffeeMachine {
    public void makeCoffee(){
        Boiler.boil();
        CoffeeAdder.addCoffee();
        SugarAdder.addSugar();
        Mixer.mix();
        System.err.println("take your coffee. result as seen by client code"); //это сообщение выводится в поток ошибок для большей наглядности
    }
}
