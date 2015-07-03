package com.annamukhina.view.commands;

import java.util.List;

/**
 * @author anna_mukhina
 *
 * Prints list of found or sorted objects (clients, devices, sales).
 */
public class PrintCommand<T> implements Command {
    private final List<T> objectToPrint;

    public PrintCommand(List<T> objectToPrint) {
        this.objectToPrint = objectToPrint;
    }

    @Override
    public void execute() {
        for(T item : objectToPrint) {
            System.out.println(item);
        }
    }
}
