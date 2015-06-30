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
public class ShowSortingMenuCommand {
    private final StringBuilder sortingMenu;
    private final Clients clients;
    private final Devices devices;
    private final Sales sales;
    private final int MAXCODE = 3;

    public ShowSortingMenuCommand(Clients clients, Devices devices, Sales sales) {
        this.sortingMenu = new StringBuilder();
        this.clients = clients;
        this.devices = devices;
        this.sales = sales;

        sortingMenu.append("\n");
        sortingMenu.append("Для возврата в главное меню введите menu\n");
        sortingMenu.append("Для завершения работы с системой введите exit\n");
        sortingMenu.append("--------------------------------------------------------\n");
        sortingMenu.append("Сортировка\n");
        sortingMenu.append("--------------------------------------------------------\n");
        sortingMenu.append("Введите цифру, соответствующую объекту сортировки:\n");
        sortingMenu.append("1 - клиенты, 2 - девайсы, 3 - продажи");
    }

    public void execute() {
        System.out.println(sortingMenu);

        Scanner scanner = new Scanner(System.in);

        int code = InputReader.readNumber(scanner, MAXCODE);

        switch (code) {
            case 1:
                SortClientsCommand sortClientsCommand = new SortClientsCommand(clients);

                sortClientsCommand.execute();

                break;
            case 2:
                SortDevicesCommand sortDevicesCommand = new SortDevicesCommand(devices);

                sortDevicesCommand.execute();

                break;
            case 3:
                SortSalesCommand sortSalesCommand = new SortSalesCommand(sales);

                sortSalesCommand.execute();

                break;
            default:
                System.out.println(Constants.fail);

                execute();
        }
    }
}
