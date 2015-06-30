package com.annamukhina.model.operations.comparators.client;

import com.annamukhina.model.entities.Client;

import java.util.Comparator;
import java.util.Date;

/**
 * @author anna_mukhina
 */
public class YearOfBirthComparator implements Comparator<Client> {
    public int compare(Client client1, Client client2) {
        Date year1 = client1.getDateOfBirth();
        Date year2 = client2.getDateOfBirth();

        return year1.compareTo(year2);
    }
}
