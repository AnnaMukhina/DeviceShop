package com.annamukhina.model.operations;

import com.annamukhina.model.entities.Sale;

import java.util.*;

/**
 * @author anna_mukhina
 *
 * Contains method for the search of the sales.
 */
public class SaleSearcher extends SearcherByID<Sale> {
    /**
     * Searches for sales by year.
     * Returns a list of the Sale objects with specified parameter.
     * If there are no sales with this year returns an empty list.
     *
     * @param desiredYear year of the sale
     * @param sales list of values of the map-storage
     * @return list of the Sale objects with this year
     */
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
