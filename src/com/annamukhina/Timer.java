package com.annamukhina;

import com.annamukhina.model.entities.Client;
import com.annamukhina.model.storages.Clients;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.Constants;

import java.text.ParseException;
import java.util.Date;

/**
 * @author anna_mukhina
 */
public class Timer {
    private final Clients clients;
    private final Devices devices;
    private final Sales sales;

    public Timer(Clients clients, Devices devices, Sales sales) {
        this.clients = clients;
        this.devices = devices;
        this.sales = sales;
    }

    public void addClients(int number) throws ParseException {
        Long t1 = System.currentTimeMillis();
        Date date = Constants.FORMAT.parse("01.01.1111");
        for(int i = 0; i < number; i++) {
            String tmp = "client"+i;
            Client client = new Client(tmp, tmp, tmp, date);
        }
        Long t2 = System.currentTimeMillis();

        System.out.println(t2-t1);
    }
}
