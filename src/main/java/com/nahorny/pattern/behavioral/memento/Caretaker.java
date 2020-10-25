/**
 * позволим себе отступить от классического примера и реализуем класс так, чтобы он возвращал не предыдущую версию, а определенную
 */
package com.nahorny.pattern.behavioral.memento;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Caretaker {
    private HashMap<String, Memento> mementos = new HashMap<>();

    public Memento getMemento(String version) {
        Memento toReturn = mementos.get(version);
        if (toReturn != null) {
            return toReturn;
        } else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
            String date = java.time.LocalTime.now().format(dtf);
            return new Memento("NO such versin", version, date);
        }

    }

    public void setMemento(Memento memento) {
        mementos.put(memento.getVersion(), memento);
    }
}
