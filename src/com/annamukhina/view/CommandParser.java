package com.annamukhina.view;

import com.annamukhina.model.storages.Clients;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.commands.AddClientCommand;
import com.annamukhina.view.commands.AddDeviceCommand;
import com.annamukhina.view.commands.AddSaleCommand;
import com.annamukhina.view.exceptions.ExitException;

/**
 * @author anna_mukhina
 */
public class CommandParser {
    private final Clients clients;
    private final Devices devices;
    private final Sales sales;

    public CommandParser(Clients clients, Devices devices, Sales sales) {
        this.clients = clients;
        this.devices = devices;
        this.sales = sales;
    }

    public void parseCommand(String command) {
        //try {
            switch (command) {
                case "addc": AddClientCommand addClientCommand= new AddClientCommand(clients);
                             addClientCommand.execute(); break;
                case "addd": AddDeviceCommand addDeviceCommand = new AddDeviceCommand(devices);
                               addDeviceCommand.execute(); break;
                case "adds": AddSaleCommand addSaleCommand = new AddSaleCommand(clients, devices, sales);
                             addSaleCommand.execute(); break;
//                case "search":  break;
//                case "sort":  break;
//                case "menu": MainMenu.showMenu(); break;
//                case "exit": throw new com.annamukhina.view.exceptions.ExitException();
//                default:
//                    System.out.println(StringsAndConstants.fail);
//
//                    MainMenu.showMenu();
            }

    }
}
