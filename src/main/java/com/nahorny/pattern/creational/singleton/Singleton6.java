/**
 * способ от товарища Joshua Bloch’а
 * <p>
 * К Enum можно применять методы:
 * name(), ordinal(), equals(), hashCode(), toString(), finalize(), clone(), values(), valueOf()
 * реализовывает интерфейс Comparable, Serializable
 * с В.5 появился абстрактный класс Enum
 *
 * если в enum добавить коестант, то получим мультитон
 */

package com.nahorny.pattern.creational.singleton;

public class Singleton6 {
    public enum Singleton {
        INSTANCE(100, "EnumSingleton");
        private int value;
        private String name;

        /**
         * конструктор для константы
         *
         */
        Singleton(int i, String name) {
            this.value = i;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Singleton{" +
                    "value=" + value +
                    ", name='" + name + '\'' +
                    '}';
        }

    }
}
