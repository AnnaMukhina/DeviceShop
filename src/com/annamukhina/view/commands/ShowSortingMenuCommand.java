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
 *
 * Calls methods for user input reading and check, executes Sort commands.
 */
public class ShowSortingMenuCommand implements Command {
    private final String sortingMenu;
    private final Clients clients;
    private final Devices devices;
    private final Sales sales;
    private final int MAXCODE = 3;

    public ShowSortingMenuCommand(Clients clients, Devices devices, Sales sales) {
        this.clients = clients;
        this.devices = devices;
        this.sales = sales;

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n");
        stringBuilder.append("Для возврата в главное меню введите menu\n");
        stringBuilder.append("Для завершения работы с системой введите exit\n");
        stringBuilder.append("--------------------------------------------------------\n");
        stringBuilder.append("Сортировка\n");
        stringBuilder.append("--------------------------------------------------------\n");
        stringBuilder.append("Введите цифру, соответствующую объекту сортировки:\n");
        stringBuilder.append("1 - клиенты, 2 - девайсы, 3 - продажи");

        this.sortingMenu = stringBuilder.toString();
    }

    @Override
    public void execute() {
        System.out.println(sortingMenu);

        Scanner scanner = new Scanner(System.in);

        try {
            int code = InputReader.getCode(scanner, MAXCODE);

            switch (Constants.CODES[code]) {
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
            }
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
