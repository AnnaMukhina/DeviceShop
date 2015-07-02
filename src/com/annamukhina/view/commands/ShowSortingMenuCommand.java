package com.annamukhina.view.commands;

import com.annamukhina.model.storages.Clients;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;
import com.annamukhina.view.MainMenu;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

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

        try {
            int code = InputReader.readNumber(scanner, MAXCODE);

            switch (Constants.codes[code]) {
                case ONE:
                    SortClientsCommand sortClientsCommand = new SortClientsCommand(clients);

                    sortClientsCommand.execute();

                    break;
                case TWO:
                    SortDevicesCommand sortDevicesCommand = new SortDevicesCommand(devices);

                    sortDevicesCommand.execute();

                    break;
                case THREE:
                    SortSalesCommand sortSalesCommand = new SortSalesCommand(sales);

                    sortSalesCommand.execute();

                    break;
                default:
                    System.out.println(Constants.fail);

                    execute();
            }
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
