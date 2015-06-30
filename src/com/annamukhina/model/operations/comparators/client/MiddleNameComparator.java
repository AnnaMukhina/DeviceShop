package com.annamukhina.model.operations.comparators.client;

import com.annamukhina.model.entities.Client;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class MiddleNameComparator implements Comparator<Client> {
    public int compare(Client client1, Client client2) {
        String middleName1 = client1.getMiddleName();
        String middleName2 = client2.getMiddleName();

        return middleName1.compareTo(middleName2);
    }
}
