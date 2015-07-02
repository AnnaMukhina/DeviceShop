package com.annamukhina.view.commands;

import com.annamukhina.controllers.sale.SaleAdditionController;
import com.annamukhina.model.entities.Client;
import com.annamukhina.model.entities.Device;
import com.annamukhina.model.operations.comparators.device.DeviceIdComparator;
import com.annamukhina.model.operations.ClientSearcher;
import com.annamukhina.model.operations.DeviceSearcher;
import com.annamukhina.model.storages.Clients;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;
import com.annamukhina.view.MainMenu;
import com.annamukhina.view.exceptions.ClientNotFoundException;
import com.annamukhina.view.exceptions.DeviceNotFoundException;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author anna_mukhina
 */
public class AddSaleCommand implements Command {
    private final Clients clients;
    private final Devices devices;
    private final SaleAdditionController saleAdditionController;
    private final String saleAdditionMenu;
    private final ClientSearcher clientSearcher;
    private final DeviceSearcher deviceSearcher;

    public AddSaleCommand(Clients clients, Devices devices, Sales sales) {
        this.clients = clients;
        this.devices = devices;
        this.clientSearcher = new ClientSearcher();
        this.deviceSearcher = new DeviceSearcher();
        this.saleAdditionController = new SaleAdditionController(sales);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n");
        stringBuilder.append("Для возврата в главное меню введите menu\n");
        stringBuilder.append("Для завершения работы с системой введите exit\n");
        stringBuilder.append("--------------------------------------------------------\n");
        stringBuilder.append("Оформление продажи\n");
        stringBuilder.append("--------------------------------------------------------");

        this.saleAdditionMenu = stringBuilder.toString();
    }

    @Override
    public void execute() {
        System.out.println(saleAdditionMenu);

        Scanner scanner = new Scanner(System.in);

        System.out.println(Constants.clientIdInput);

        try {
            int clientID = InputReader.getCode(scanner, Constants.maxClientID);

            Client client = getClient(clientID);

            System.out.println(Constants.orderInput);

            Map<Device, Integer> order = readOrder();

            saleAdditionController.addSale(client, order);

            System.out.println(Constants.saleAdditionSuccess);
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClientNotFoundException cnfe) {
            System.out.println(Constants.clientNotFound);

            AddClientCommand addClientCommand = new AddClientCommand(clients);

            addClientCommand.execute();
        }
    }

    private Map<Device, Integer> readOrder() throws IOException {
        Map<Device, Integer> order = new TreeMap<>(new DeviceIdComparator());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while(!input.equals("-")) {

            String[] position = input.split(" ");

            int deviceID = Integer.parseInt(position[0]);

            int number = Integer.parseInt(position[1]);

            try {
                Device device = getDevice(deviceID);

                order.put(device, number);

                input = reader.readLine();

            } catch (DeviceNotFoundException dnfe) {
                System.out.println(Constants.deviceNotFound);

                input = reader.readLine();
            }
        }
        reader.close();

        return order;
    }

    private Client getClient(int clientID) throws ClientNotFoundException {
        Client client = clientSearcher.findByID(clients.getClients(), clientID);
        if(client == null) {
            throw new ClientNotFoundException();
        }
        else {
            return client;
        }
    }

    private Device getDevice(int deviceID) throws DeviceNotFoundException {
        Device device = deviceSearcher.findByID(devices.getDeviceMap(), deviceID);
        if(device == null) {
            throw new DeviceNotFoundException();
        }
        else {
            return device;
        }
    }
}
