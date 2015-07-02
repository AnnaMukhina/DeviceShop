package com.annamukhina.view.commands;

import com.annamukhina.controllers.client.ClientAdditionController;
import com.annamukhina.model.storages.Clients;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;
import com.annamukhina.view.MainMenu;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

import java.util.Date;
import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class AddClientCommand implements Command {
    private final ClientAdditionController clientAdditionController;
    private final StringBuilder clientAdditionMenu;

    public AddClientCommand(Clients clients) {
        this.clientAdditionController = new ClientAdditionController(clients);
        this.clientAdditionMenu = new StringBuilder();

        clientAdditionMenu.append("\n");
        clientAdditionMenu.append("Для возврата в главное меню введите menu\n");
        clientAdditionMenu.append("Для завершения работы с системой введите exit\n");
        clientAdditionMenu.append("--------------------------------------------------------\n");
        clientAdditionMenu.append("Внесение в базу нового клиента\n");
        clientAdditionMenu.append("--------------------------------------------------------");
    }

    public void execute() {
        System.out.println(clientAdditionMenu);

        Scanner scanner = new Scanner(System.in);

        System.out.println(Constants.surnameInput);

        try {
            String surname = InputReader.getString(scanner);

            System.out.println(Constants.nameInput);

            String name = InputReader.getString(scanner);

            System.out.println(Constants.middleNameInput);

            String middleName = InputReader.getString(scanner);

            System.out.println(Constants.dateInput);

            Date dateOfBirth = InputReader.getDate(scanner);

            clientAdditionController.addClient(surname, name, middleName, dateOfBirth);

            System.out.println(Constants.clientAdditionSuccess);
        } catch (GoToMenuException gtme) {
            MainMenu.showMenu();
        } catch (ExitException ee) {
            MainMenu.setActive(false);
        }
    }
}
