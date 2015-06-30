package com.annamukhina.view.commands;

import com.annamukhina.controller.search.ClientSearchController;
import com.annamukhina.model.storages.Clients;
import com.annamukhina.view.Constants;
import com.annamukhina.view.Helper;
import com.annamukhina.view.InputReader;

import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class SearchClientCommand implements Command {
    private final ClientSearchController clientSearchController;
    private final Clients clients;
    private final String clientSearchMenu;
    private String surname;
    private String name;
    private String middleName;

    public SearchClientCommand(Clients clients) {
        this.clients = clients;
        this.clientSearchController = new ClientSearchController(clients);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите цифру, соответствующую параметру поиска:\n");
        stringBuilder.append("1 - id, 2 - ФИО клиента");

        clientSearchMenu = stringBuilder.toString();
    }

    public void execute() {
        System.out.println(clientSearchMenu);

        Scanner scanner = new Scanner(System.in);

        String parameterOfSearch = scanner.next();

        switch (parameterOfSearch) {
            case "0":
                int clientID = InputReader.getCode(scanner, Constants.maxClientID);

                clientSearchController.findByID(clientID);

                break;
            case "1":
                System.out.println(Constants.surnameInput);

                this.surname = InputReader.getString(scanner);

                System.out.println(Constants.nameInput);

                this.name = InputReader.getString(scanner);

                System.out.println(Constants.middleNameInput);

                this.middleName = InputReader.getString(scanner);

                clientSearchController.findByFullName(surname, name, middleName);

                break;
            case "exit":
                Helper.setActive(false);

                break;
            case "menu": break;
            default:
                System.out.println(Constants.fail);

                execute();
        }
    }
}
