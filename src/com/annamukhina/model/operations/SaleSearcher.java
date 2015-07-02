package com.annamukhina.model.operations;

import com.annamukhina.model.entities.Sale;

import java.util.*;

/**
 * @author anna_mukhina
 */
public class SaleSearcher extends SearcherByID<Sale> {
    public List<Sale> findByYear(int desiredYear, List<Sale> sales) {
        List<Sale> found = new ArrayList<>();

        Calendar patternDate = Calendar.getInstance();
        Calendar dateToCompare = Calendar.getInstance();

        patternDate.set(Calendar.YEAR, desiredYear);

        for (Sale sale : sales) {
            Date date = sale.getDate();

            dateToCompare.setTime(date);

            if (patternDate.get(Calendar.YEAR) == dateToCompare.get(Calendar.YEAR)) {
                found.add(sale);
            }
        }
        return found;
    }
}
