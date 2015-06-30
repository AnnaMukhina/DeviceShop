package com.annamukhina.model.operations.comparators.sale;

import com.annamukhina.model.entities.Sale;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class SaleIdComparator implements Comparator<Sale> {
    public int compare(Sale sale1, Sale sale2) {
        int id1 = sale1.getId();
        int id2 = sale2.getId();

        return id1 - id2;
    }
}
