package com.annamukhina.model.operations.comparators.client;

import com.annamukhina.model.entities.Client;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class SurnameComparator implements Comparator<Client> {
    public int compare(Client client1, Client client2) {
        String surname1 = client1.getSurname();
        String surname2 = client2.getSurname();

        return surname1.compareTo(surname2);
    }
}
