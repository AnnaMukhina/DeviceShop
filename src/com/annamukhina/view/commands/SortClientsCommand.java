package com.annamukhina.view.commands;

import com.annamukhina.controller.sorting.ClientsSortingController;
import com.annamukhina.model.entities.Client;
import com.annamukhina.model.storages.Clients;
import com.annamukhina.view.Constants;

import java.util.List;
import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class SortClientsCommand implements  Command {
    private final Clients clients;
    private final ClientsSortingController clientsSortingController;
    private final String clientsSortingMenu;
    private List<Client> result;

    public SortClientsCommand(Clients clients) {
        this.clients = clients;
        this.clientsSortingController = new ClientsSortingController(clients);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите цифру, соответствующую параметру сортировки:\n");
        stringBuilder.append("1 - id, 2 - фамилия, 3 - имя, 4 - отчество, 5 - год рождения");

        this.clientsSortingMenu = stringBuilder.toString();
    }

    @Override
    public void execute() {
        System.out.println(clientsSortingMenu);

        Scanner scanner = new Scanner(System.in);

        String parameterOfSort = scanner.next();

        switch (parameterOfSort) {
            case "1":
                this.result = clientsSortingController.getSortedByID();

                break;
            case "2":
                this.result = clientsSortingController.getSortedBySurname();

                break;
            case "3":
                this.result = clientsSortingController.getSortedByName();

                break;
            case "4":
                this.result = clientsSortingController.getSortedByMiddleName();

                break;
            case "5":
                this.result = clientsSortingController.getSortedByYearOfBirth();

                break;
            case "menu":
                break;
            case "exit":
                break;
            default:
                System.out.println(Constants.fail);

                execute();
        }

        PrintCommand<Client> printCommand = new PrintCommand<>(result);

        printCommand.execute();
    }
}
