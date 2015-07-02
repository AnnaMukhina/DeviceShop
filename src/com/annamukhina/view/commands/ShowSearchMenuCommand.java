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
public class ShowSearchMenuCommand implements Command {
    private final String searchMenu;
    private final Clients clients;
    private final Devices devices;
    private final Sales sales;
    private final int MAXCODE = 3;

    public ShowSearchMenuCommand(Clients clients, Devices devices, Sales sales) {
        this.clients = clients;
        this.devices = devices;
        this.sales = sales;

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n");
        stringBuilder.append("Для возврата в главное меню введите menu\n");
        stringBuilder.append("Для завершения работы с системой введите exit\n");
        stringBuilder.append("--------------------------------------------------------\n");
        stringBuilder.append("Поиск\n");
        stringBuilder.append("--------------------------------------------------------\n");
        stringBuilder.append("Введите цифру, соответствующую объекту поиска:\n");
        stringBuilder.append("1 - клиенты, 2 - девайсы, 3 - продажи");

        this.searchMenu = stringBuilder.toString();
    }

    @Override
    public void execute() {
        System.out.println(searchMenu);

        Scanner scanner = new Scanner(System.in);

        try {
            int code = InputReader.getCode(scanner, MAXCODE);

            switch (Constants.CODES[code]) {
                case ONE:
                    SearchClientCommand searchClientCommand = new SearchClientCommand(clients);

                    searchClientCommand.execute();

                    break;
                case TWO:
                    SearchDeviceCommand searchDeviceCommand = new SearchDeviceCommand(devices);

                    searchDeviceCommand.execute();

                    break;
                case THREE:
                    SearchSaleCommand searchSaleCommand = new SearchSaleCommand(sales);

                    searchSaleCommand.execute();

                    break;
            }
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
