package com.annamukhina.model.operations.comparators.client;

import com.annamukhina.model.entities.Client;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class NameComparator implements Comparator<Client> {
    public int compare(Client client1, Client client2) {
        String name1 = client1.getName();
        String name2 = client2.getName();

        return name1.compareTo(name2);
    }
}
