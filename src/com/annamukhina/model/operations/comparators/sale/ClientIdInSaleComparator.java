package com.annamukhina.model.operations.comparators.sale;

import com.annamukhina.model.entities.Sale;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class ClientIdInSaleComparator implements Comparator<Sale> {
    public int compare(Sale sale1, Sale sale2) {
        int clientID1 = sale1.getClient().getId();
        int clientID2 = sale2.getClient().getId();

        return clientID1 - clientID2;
    }
}
