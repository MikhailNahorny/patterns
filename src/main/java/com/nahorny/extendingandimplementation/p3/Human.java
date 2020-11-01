package com.nahorny.extendingandimplementation.p3;

public class Human {
    private int age;
    public String name;
    private String profession;

    public Human(int age, String name, String profession) {
        if(age < 0 | age > 150) throw new IllegalArgumentException("bad age");
        if (name == null || name.length() < 2)  throw new IllegalArgumentException("bad name");
        this.age = age;
        this.name = name;
        this.profession = profession;
    }

    public Human getHuman(int age, String name, String profession) {
        return new Human(age, name, profession);
    }

    public Human getHuman(int age, String name) {
        //это перегруженный метод. перегрузка - один из интрументов полиморфизма.
        //больше одного метода с одним именем, но разными аргументами
        return new Human(age, name, "n/a");
    }

    public Human getHuman(String profession, int age, String name) {
        //порядок аргументов тоже важен и его изменение также является перегрузкой
        //стоит сказать, что public Human getHuman(int age, String profession, String name) не скомилируется
        //потому что компилятор видит (int, String, String), а такой набор был объявлен в первом случае
        //т е, имя формальной переменной не имеет значения в этом случае
        return new Human(age, name, profession);
    }

    public void doWork() {
        if(profession.equals("n/a") | age < 16) System.out.println("I have to get a profession first");
        else if (age > 65) System.out.println("I'm on retirement");
        //вот тут мы подошли к необходимости абстрактного класса, но об этом в p2
        else System.out.println("I'm doing smth");
    }

    public int getAge() {
        return age;
    }
}
