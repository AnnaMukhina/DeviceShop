package com.annamukhina.controllers.client;

import com.annamukhina.model.entities.Client;
import com.annamukhina.model.storages.Clients;

import java.util.Date;

/**
 * @author anna_mukhina
 *
 * Controller for client addition to Clients storage.
 */
public class ClientAdditionController {
    private final Clients clients;

    public ClientAdditionController(Clients clients) {
        this.clients = clients;
    }

    /**
     * Calls method for client addition from Model.
     *
     * @param surname client's surname
     * @param name client's name
     * @param middleName client's middle name
     * @param dateOfBirth client's date of birth
     */
    public void addClient(String surname, String name, String middleName, Date dateOfBirth) {
        Client newClient = new Client(surname, name, middleName, dateOfBirth);

        clients.addClient(newClient);
    }
}
