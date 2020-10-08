/**
 * Strategy
 * поведенческий паттрен, состоит из интерфейса поведения (Strategy) и реализаций этого интерфейса (ConcreteStrategyA и B)
 * объединенных по признаку реализуемого интерфейса, а значит объекты этих классов можно передать
 * по ссылке интерфейса и у любого объекта (ConcreteStrategy) вызвать метод, задекларированный в интерфейсе.
 * паттерн содержит класс исполнитель, который сранит поле типа Strategy, устанавливаемое сеттером.
 * реализаций стратегии может быть сколь-угодно много, они могут быть переданы в исполнитель и выполнены без измененпия кода исполнителя
 */

package com.nahorny.pattern.behavioral.strategy;

public class Client {
    public static void main(String[] args) {
        Executor executor = new Executor();
        executor.setStrategy(new ConcreteStrategyA());
        executor.execute();
        executor.setStrategy(new ConcreteStrategyA());
        executor.execute();
    }
}
