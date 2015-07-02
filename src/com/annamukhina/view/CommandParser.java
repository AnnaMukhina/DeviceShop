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
        command = command.toUpperCase();
        try {
            switch (Constants.Command.valueOf(command)) {
                case CLIENT:
                    AddClientCommand addClientCommand= new AddClientCommand(clients);
                    addClientCommand.execute();
                    break;
                case DEVICE:
                    AddDeviceCommand addDeviceCommand = new AddDeviceCommand(devices);
                    addDeviceCommand.execute();
                    break;
                case SALE:
                    AddSaleCommand addSaleCommand = new AddSaleCommand(clients, devices, sales);
                    addSaleCommand.execute();
                    break;
                case SEARCH:
                    ShowSearchMenuCommand showSearchMenuCommand = new ShowSearchMenuCommand(clients, devices, sales);
                    showSearchMenuCommand.execute();
                    break;
                case SORT:
                    ShowSortingMenuCommand showSortingMenuCommand = new ShowSortingMenuCommand(clients, devices, sales);
                    showSortingMenuCommand.execute();
                    break;
                case MENU:
                    throw new GoToMenuException();
                case EXIT:
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
