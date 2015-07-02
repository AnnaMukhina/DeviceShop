package com.annamukhina.controllers.sale;

import com.annamukhina.model.entities.Sale;
import com.annamukhina.model.operations.comparators.sale.OrderSizeComparator;
import com.annamukhina.model.operations.Sorter;
import com.annamukhina.model.operations.comparators.sale.ClientIdInSaleComparator;
import com.annamukhina.model.operations.comparators.sale.DateComparator;
import com.annamukhina.model.operations.comparators.sale.SaleIdComparator;
import com.annamukhina.model.storages.Sales;

import java.util.List;

/**
 * @author anna_mukhina
 */
public class SalesSortingController {
    private final Sorter<Sale> sorter;
    private final List<Sale> saleList;

    public SalesSortingController(Sales sales) {
        this.sorter = new Sorter<>();
        this.saleList = sales.getSalesList();
    }

    public List<Sale> getSortedByID() {
        return sorter.getResultOfSort(saleList, new SaleIdComparator());
    }

    public List<Sale> getSortedByClientID() {
        return sorter.getResultOfSort(saleList, new ClientIdInSaleComparator());
    }

    public List<Sale> getSortedByDate() {
        return sorter.getResultOfSort(saleList, new DateComparator());
    }

    public List<Sale> getSortedByOrderSize() {
        return sorter.getResultOfSort(saleList, new OrderSizeComparator());
    }
}
