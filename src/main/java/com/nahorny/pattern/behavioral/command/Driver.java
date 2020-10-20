/**
 * посылает команду
 */
package com.nahorny.pattern.behavioral.command;

import java.util.HashMap;

public class Driver {
    private final HashMap<String, Command> commands = new HashMap<>();

    public void addCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void execute(String name) {
        Command command = commands.get(name);
        if (command == null) {
            throw new IllegalStateException("no such command");
        }
        command.execute();
    }
}
