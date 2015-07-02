package com.annamukhina.view.commands;

import com.annamukhina.controllers.client.ClientSearchController;
import com.annamukhina.model.storages.Clients;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;
import com.annamukhina.view.MainMenu;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class SearchClientCommand implements Command {
    private final ClientSearchController clientSearchController;
    private final String clientSearchMenu;
    private final int MAXCODE = 2;
    private String surname;
    private String name;
    private String middleName;

    public SearchClientCommand(Clients clients) {
        this.clientSearchController = new ClientSearchController(clients);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите цифру, соответствующую параметру поиска:\n");
        stringBuilder.append("1 - id, 2 - ФИО клиента");

        clientSearchMenu = stringBuilder.toString();
    }

    public void execute() {
        System.out.println(clientSearchMenu);

        Scanner scanner = new Scanner(System.in);

        try {
            int parameterOfSearch = InputReader.getCode(scanner, MAXCODE);

            switch (Constants.codes[parameterOfSearch]) {
                case ONE:
                    int clientID = InputReader.getCode(scanner, Constants.maxClientID);

                    clientSearchController.findByID(clientID);

                    break;
                case TWO:
                    System.out.println(Constants.surnameInput);

                    this.surname = InputReader.getString(scanner);

                    System.out.println(Constants.nameInput);

                    this.name = InputReader.getString(scanner);

                    System.out.println(Constants.middleNameInput);

                    this.middleName = InputReader.getString(scanner);

                    clientSearchController.findByFullName(this.surname, this.name, this.middleName);

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
