package com.annamukhina.controllers.client;

import com.annamukhina.model.entities.Client;
import com.annamukhina.model.operations.search.ClientSearcher;
import com.annamukhina.model.storages.Clients;

import java.util.List;
import java.util.Map;

/**
 * @author anna_mukhina
 */
public class ClientSearchController {
    private final Clients clients;
    private final ClientSearcher clientSearcher;
    private final Map<Integer, Client> clientMap;

    public ClientSearchController(Clients clients) {
        this.clients = clients;
        this.clientSearcher = new ClientSearcher();
        this.clientMap = clients.getClients();
    }

    public List<Client> findByFullName(String surname, String name, String middleName) {
        List<Client> clientsList = clients.getClientList();
        return clientSearcher.findByFullName(surname, name, middleName, clientsList);
    }

    public Client findByID(int id) {
        return clientSearcher.findByID(clientMap, id);
    }
}
