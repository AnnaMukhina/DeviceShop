package com.annamukhina.view;

import com.annamukhina.model.storages.Clients;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.commands.*;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

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
        try {
            switch (command) {
                case "client":
                    AddClientCommand addClientCommand= new AddClientCommand(clients);
                    addClientCommand.execute();
                    break;
                case "device":
                    AddDeviceCommand addDeviceCommand = new AddDeviceCommand(devices);
                    addDeviceCommand.execute();
                    break;
                case "sale":
                    AddSaleCommand addSaleCommand = new AddSaleCommand(clients, devices, sales);
                    addSaleCommand.execute();
                    break;
                case "search":
                    ShowSearchMenuCommand showSearchMenuCommand = new ShowSearchMenuCommand(clients, devices, sales);
                    showSearchMenuCommand.execute();
                    break;
                case "sort":
                    ShowSortingMenuCommand showSortingMenuCommand = new ShowSortingMenuCommand(clients, devices, sales);
                    showSortingMenuCommand.execute();
                    break;
                case "menu":
                    throw new GoToMenuException();
                case "exit":
                    throw new ExitException();
                default:
                    System.out.println(Constants.fail);

                    MainMenu.showMenu();
            }
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
