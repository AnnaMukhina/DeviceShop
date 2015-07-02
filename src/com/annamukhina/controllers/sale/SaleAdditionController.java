package com.annamukhina.controllers.sale;

import com.annamukhina.model.entities.Client;
import com.annamukhina.model.entities.Device;
import com.annamukhina.model.entities.Sale;
import com.annamukhina.model.storages.Sales;

import java.util.Map;

/**
 * @author anna_mukhina
 */
public class SaleAdditionController {
    private final Sales sales;

    public SaleAdditionController(Sales sales) {
        this.sales = sales;
    }

    public void addSale(Client client, Map<Device, Integer> order) {
        Sale newSale = new Sale(client, order);

        sales.addSale(newSale);
    }
}
