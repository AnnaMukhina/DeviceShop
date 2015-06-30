package com.annamukhina.view.commands;

import com.annamukhina.controller.addition.SaleAdditionController;
import com.annamukhina.model.entities.Client;
import com.annamukhina.model.entities.Device;
import com.annamukhina.model.operations.comparators.device.DeviceIdComparator;
import com.annamukhina.model.operations.search.ClientSearcher;
import com.annamukhina.model.operations.search.DeviceSearcher;
import com.annamukhina.model.storages.Clients;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author anna_mukhina
 */
public class AddSaleCommand implements Command {
    private final Clients clients;
    private final Devices devices;
    private final Sales sales;
    private final SaleAdditionController saleAdditionController;
    private final StringBuilder saleAdditionMenu;
    private final ClientSearcher clientSearcher;
    private final DeviceSearcher deviceSearcher;
    private final int MAXNUMBER = 5;

    public AddSaleCommand(Clients clients, Devices devices, Sales sales) {
        this.clients = clients;
        this.devices = devices;
        this.clientSearcher = new ClientSearcher();
        this.deviceSearcher = new DeviceSearcher();
        this.sales = sales;
        this.saleAdditionController = new SaleAdditionController(sales);
        this.saleAdditionMenu = new StringBuilder();

        saleAdditionMenu.append("\n");
        saleAdditionMenu.append("Для возврата в главное меню введите menu\n");
        saleAdditionMenu.append("Для завершения работы с системой введите exit\n");
        saleAdditionMenu.append("--------------------------------------------------------\n");
        saleAdditionMenu.append("Оформление продажи\n");
        saleAdditionMenu.append("--------------------------------------------------------");
    }

    public void execute() {
        System.out.println(saleAdditionMenu);

        Scanner scanner = new Scanner(System.in);

        System.out.println(Constants.clientIdInput);

        int clientID = InputReader.getCode(scanner, Constants.maxClientID);

        Client client = clientSearcher.findByID(clients.getClients(), clientID);
//            if(client == null) {
//                throw new ClientNotFoundException();
//            }
//        }
//        catch (ClientNotFoundException cnfe) {
//            System.out.println("Клиент с таким id не существует. Внесите его в систему.");
//            AddClientCommand addClientCommand = new AddClientCommand(clients);
//        }

        System.out.println(Constants.orderInput);
        try {
            Map<Device, Integer> order = readOrder();

            saleAdditionController.addSale(client, order);

            System.out.println(Constants.saleAdditionSuccess);
        }
        catch (IOException ioe) {}

    }

    private Map<Device, Integer> readOrder() throws IOException {
        Map<Device, Integer> order = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while(!reader.readLine().equals("")) {
            String[] position = input.split(" ");

            int deviceID = Integer.parseInt(position[0]);

            System.out.println("deviceId" + deviceID);

            int number = Integer.parseInt(position[1]);

            System.out.println("number "+ number);

            Device device = deviceSearcher.findByID(devices.getDeviceMap(), deviceID); //TODO check input

            order.put(device, number);
        }
        return order;
    }
}
