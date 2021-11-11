package com.nahorny.collections.myimplementation;

import java.util.Comparator;

public class Car {

    private String manufacturer;
    private String model;
    private int year;
    private String color;
    private boolean fuel;
    private int price;

    public Car(String manufacturer, String model, int year, String color, boolean fuel, int price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.color = color;
        this.fuel = fuel;
        this.price = price;
    }

    @Override
    public String toString() {
        String res = "";
        res = manufacturer + ", "
                + model + ", "
                + year + ", "
                + color + ", "
                + ((fuel) ? "petrol" : "diesel fuel") + ", "
                + price;

        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                fuel == car.fuel &&
                price == car.price &&
                manufacturer.equals(car.manufacturer) &&
                model.equals(car.model) &&
                color.equals(car.color);
    }

    public static Comparator<Car> ByYear = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            if (car1 != null && car2 != null) {
                return car1.year - car2.year;
            } else return 0;
        }
    };

    public static Comparator<Car> ByPrice = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            if (car1 != null && car2 != null) {
                return car1.price - car2.price;
            } else return 0;
        }
    };

}

