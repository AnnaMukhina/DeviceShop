package com.annamukhina.model.storages;

import com.annamukhina.model.entities.Sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author anna_mukhina
 */
public class Sales {
    private Map<Integer, Sale> sales; //storage

    public Sales() {
        sales = new TreeMap<>();
    }

    public Map<Integer, Sale> getSalesMap() {
        return sales;
    }

    public void addSale(Sale sale) {
        sales.put(sale.getId(), sale);
    }

    public List<Sale> getSalesList() {
        return new ArrayList<>(sales.values());
    }
}
