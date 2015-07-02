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
 *
 * Controller for sales sorting.
 */
public class SalesSortingController {
    private final Sorter<Sale> sorter; //contains methods for sorting
    private final List<Sale> saleList; //List of values of the map-storage

    public SalesSortingController(Sales sales) {
        this.sorter = new Sorter<>();
        this.saleList = sales.getSalesList();
    }

    /**
     * Calls method for sales sorting by id from Model.
     *
     * @return sorted by id list of the Sale objects
     */
    public List<Sale> getSortedByID() {
        return sorter.getResultOfSort(saleList, new SaleIdComparator());
    }
    /**
     * Calls method for sales sorting by client's id from Model.
     *
     * @return sorted by client's id list of the Sale objects
     */
    public List<Sale> getSortedByClientID() {
        return sorter.getResultOfSort(saleList, new ClientIdInSaleComparator());
    }
    /**
     * Calls method for sales sorting by date from Model.
     *
     * @return sorted by date of the sale list of the Sale objects
     */
    public List<Sale> getSortedByDate() {
        return sorter.getResultOfSort(saleList, new DateComparator());
    }
    /**
     * Calls method for sales sorting by number of items in order from Model.
     *
     * @return sorted by number of items in order list of the Sale objects
     */
    public List<Sale> getSortedByOrderSize() {
        return sorter.getResultOfSort(saleList, new OrderSizeComparator());
    }
}
