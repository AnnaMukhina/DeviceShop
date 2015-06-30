package com.annamukhina.view.commands;

import java.util.List;

/**
 * @author anna_mukhina
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
