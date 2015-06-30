package com.annamukhina.view;

import com.annamukhina.model.storages.Clients;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.model.storages.Sales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author anna_mukhina
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Clients clients = new Clients();
        Devices devices = new Devices();
        Sales sales = new Sales();

        MainMenu menu = new MainMenu();

        MainMenu.showMenu();

        CommandParser commandParser = new CommandParser(clients, devices, sales);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(Helper.isActive()) {
            System.out.println("Введите команду:");

            String command = reader.readLine().toLowerCase();

            commandParser.parseCommand(command);
        }
    }
}
