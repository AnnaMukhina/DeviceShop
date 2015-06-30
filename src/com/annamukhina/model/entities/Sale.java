package com.annamukhina.model.entities;

import com.annamukhina.view.Constants;

import java.util.Date;
import java.util.Map;

/**
 * @author anna_mukhina
 */
public class Sale {
    public static int lastID = 0;
    private final int id;
    private final Client client;
    private final Map<Device, Integer> order;
    private final Date date;

    public Sale(Client client, Map<Device, Integer> order) {
        lastID++;
        this.id = lastID;
        this.client = client;
        this.order = order;
        this.date = new Date();
    }

    public Client getClient() {
        return client;
    }

    public Map<Device, Integer> getOrder() {
        return order;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    private StringBuilder showOrder() {
        StringBuilder output = new StringBuilder();

        for(Device device : order.keySet()) {
            output.append(device.toString() + "\n");
        }
        return output;
    }

    @Override
    public String toString() {
        StringBuilder order = showOrder();
        return id + " " + Constants.format.format(date) + "\n" + client + "\n" + order;
    }
}
