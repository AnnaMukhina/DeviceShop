package com.annamukhina.controllers.sale;

import com.annamukhina.model.entities.Sale;
import com.annamukhina.model.operations.SaleSearcher;
import com.annamukhina.model.storages.Sales;

import java.util.List;

/**
 * @author anna_mukhina
 */
public class SaleSearchController {
    private final Sales sales;
    private final SaleSearcher saleSearch;

    public SaleSearchController(Sales sales) {
        this.sales = sales;
        this.saleSearch = new SaleSearcher();
    }

    public List<Sale> findByYear(int year) {
        return saleSearch.findByYear(year, sales.getSalesList());
    }
}
