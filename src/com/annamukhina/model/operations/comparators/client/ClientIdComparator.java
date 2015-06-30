package com.annamukhina.model.operations.comparators.client;

import com.annamukhina.model.entities.Client;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class ClientIdComparator implements Comparator<Client> {
    public int compare(Client client1, Client client2) {
        int id1 = client1.getId();
        int id2 = client2.getId();

        return id1 - id2;
    }
}
