package com.annamukhina.model.operations.comparators.sale;

import com.annamukhina.model.entities.Sale;

import java.util.Collection;
import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class OrderSizeComparator implements Comparator<Sale> {
    public int compare(Sale sale1, Sale sale2) {
        Collection<Integer> values1 = sale1.getOrder().values();
        Collection<Integer> values2 = sale2.getOrder().values();

        int size1 = 0;
        int size2 = 0;

        for(Integer integer : values1) {
            size1 += integer;
        }

        for(Integer integer : values2) {
            size2 += integer;
        }

        return size1 - size2;
    }
}
