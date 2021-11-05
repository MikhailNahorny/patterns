package com.nahorny.inheritanceandimplementation.p3overrideandoverload;

public class Carpenter extends Human{
    private int experience;

    //конструктор может быть приватным для ограничения создания экземпляров класса
    private Carpenter(int age, String name, int experience) {
        //конструктор базового класса должен быть вызван первой строкой в конструкторе подкласса
        //в базовом классе должен присутствовать конструктор по умолчанию
        super(age, name, "Carpenter");
        this.experience = experience;
    }

    public Carpenter getCarpenter(int age, String name, int experience){
        if(age < 16) System.out.println("I'm too young");
        return new Carpenter(age, name, experience);
    }

    public int getExperience() {
        return experience;
    }

    //без аннотации тоже работает неплохо, но мы можем допустить ошибку в сигнатуре и не заметить этого
    //с аннотацией компилятор выдаст ошибку
    @Override
    //это переопределение метода: другая логика за одинаковой сигнатурой
    public void doWork() {
        //в отличие от Human.doWork(), здесь мы точно знаем профессию, потому проверка не нужна
        // и возраст не может быть < 16, потому этой проверки тоже нет
        if (this.getAge() > 65) System.out.println("I'm on retirement");
        //и самое наглядное, работник определенной профессии работает определенным образом
        else System.out.println("I'm building a wooden house");
    }
}
