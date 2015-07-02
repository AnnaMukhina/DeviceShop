package com.annamukhina.view.commands;

import com.annamukhina.controllers.client.ClientsSortingController;
import com.annamukhina.model.entities.Client;
import com.annamukhina.model.storages.Clients;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;
import com.annamukhina.view.MainMenu;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

import java.util.List;
import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class SortClientsCommand implements  Command {
    private final ClientsSortingController clientsSortingController;
    private final String clientsSortingMenu;
    private final int MAXCODE = 5;
    private List<Client> result;

    public SortClientsCommand(Clients clients) {
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

        try {
            int parameterOfSort = InputReader.getCode(scanner, MAXCODE);

            switch (Constants.CODES[parameterOfSort]) {
                case ONE:
                    this.result = clientsSortingController.getSortedByID();

                    break;
                case TWO:
                    this.result = clientsSortingController.getSortedBySurname();

                    break;
                case THREE:
                    this.result = clientsSortingController.getSortedByName();

                    break;
                case FOUR:
                    this.result = clientsSortingController.getSortedByMiddleName();

                    break;
                case FIVE:
                    this.result = clientsSortingController.getSortedByYearOfBirth();

                    break;
            }
            PrintCommand<Client> printCommand = new PrintCommand<>(result);

            printCommand.execute();

        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
