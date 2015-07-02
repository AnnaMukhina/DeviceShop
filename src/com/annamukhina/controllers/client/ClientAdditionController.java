package com.annamukhina.controllers.client;

import com.annamukhina.model.entities.Client;
import com.annamukhina.model.storages.Clients;

import java.util.Date;

/**
 * @author anna_mukhina
 */
public class ClientAdditionController {
    private final Clients clients;

    public ClientAdditionController(Clients clients) {
        this.clients = clients;
    }

    public void addClient(String surname, String name, String middleName, Date dateOfBirth) {
        Client newClient = new Client(surname, name, middleName, dateOfBirth);

        clients.addClient(newClient);
    }
}
