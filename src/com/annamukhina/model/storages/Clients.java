package com.annamukhina.model.storages;

import com.annamukhina.model.entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author anna_mukhina
 */
public class Clients {
    private Map<Integer, Client> clients;

    public Clients() {
        clients = new TreeMap<>();
    }

    public Map<Integer, Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.put(client.getId(), client);
    }

    public List<Client> getClientList() {
        return new ArrayList<>(clients.values());
    }
}
