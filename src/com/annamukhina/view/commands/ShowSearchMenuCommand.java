package com.annamukhina.view.commands;

import com.annamukhina.model.storages.Clients;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;

import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class ShowSearchMenuCommand implements Command {
    private final StringBuilder searchMenu;
    private final Clients clients;
    private final Devices devices;
    private final Sales sales;
    private final int MAXCODE = 3;

    public ShowSearchMenuCommand(Clients clients, Devices devices, Sales sales) {
        this.searchMenu = new StringBuilder();
        this.clients = clients;
        this.devices = devices;
        this.sales = sales;

        searchMenu.append("\n");
        searchMenu.append("Для возврата в главное меню введите menu\n");
        searchMenu.append("Для завершения работы с системой введите exit\n");
        searchMenu.append("--------------------------------------------------------\n");
        searchMenu.append("Поиск\n");
        searchMenu.append("--------------------------------------------------------\n");
        searchMenu.append("Введите цифру, соответствующую объекту поиска:\n");
        searchMenu.append("1 - клиенты, 2 - девайсы, 3 - продажи");
    }

    public void execute() {
        System.out.println(searchMenu);

        Scanner scanner = new Scanner(System.in);

        int code = InputReader.readNumber(scanner, MAXCODE);

        switch (code) {
            case 1:
                SearchClientCommand searchClientCommand = new SearchClientCommand(clients);

                searchClientCommand.execute();

                break;
            case 2:
                SearchDeviceCommand searchDeviceCommand = new SearchDeviceCommand(devices);

                searchDeviceCommand.execute();

                break;
            case 3:
                SearchSaleCommand searchSaleCommand = new SearchSaleCommand(sales);

                searchSaleCommand.execute();

                break;
            default:
                System.out.println(Constants.fail);

                execute();
        }
    }
}
