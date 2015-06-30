package com.annamukhina.model.operations.comparators.sale;

import com.annamukhina.model.entities.Sale;

import java.util.Comparator;
import java.util.Date;

/**
 * @author anna_mukhina
 */
public class DateComparator implements Comparator<Sale> {
    public int compare(Sale sale1, Sale sale2) {
        Date date1 = sale1.getDate();
        Date date2 = sale2.getDate();

        return date1.compareTo(date2);
    }
}
