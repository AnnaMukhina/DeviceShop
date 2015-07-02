package com.annamukhina.view;

import com.annamukhina.model.storages.Clients;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.model.storages.Sales;

import java.util.Scanner;


/**
 * @author anna_mukhina
 */
public class Main {
    public static void main(String[] args) {
        Clients clients = new Clients();
        Devices devices = new Devices();
        Sales sales = new Sales();

        MainMenu.createMenu();

        MainMenu.showMenu();

        CommandParser commandParser = new CommandParser(clients, devices, sales);

        Scanner scanner = new Scanner(System.in);

        while(MainMenu.isActive()) {
            System.out.println(Constants.MESSAGE);

            String command = scanner.next();

            commandParser.parseCommand(command);
        }
    }
}
