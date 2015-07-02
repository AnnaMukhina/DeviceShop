package com.annamukhina.controllers.sale;

import com.annamukhina.model.entities.Sale;
import com.annamukhina.model.operations.SaleSearcher;
import com.annamukhina.model.storages.Sales;

import java.util.List;

/**
 * @author anna_mukhina
 *
 * Controller for search of the sales.
 */
public class SaleSearchController {
    private final Sales sales; //storage
    private final SaleSearcher saleSearch; //contains methods for the sale search

    public SaleSearchController(Sales sales) {
        this.sales = sales;
        this.saleSearch = new SaleSearcher();
    }

    /**
     * Calls method for search of the sales by year from Model.
     * Returns list of the Sale objects with specified parameter.
     * If there are no sales with this year returns an empty list.
     *
     * @param year year of the sale
     * @return list of the Sale objects with this year
     */
    public List<Sale> findByYear(int year) {
        return saleSearch.findByYear(year, sales.getSalesList());
    }
}
