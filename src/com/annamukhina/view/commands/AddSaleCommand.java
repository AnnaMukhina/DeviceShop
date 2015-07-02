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
import com.annamukhina.view.exceptions.*;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            Map<Device, Integer> order = getOrder();

            if(order.size() != 0) {
                saleAdditionController.addSale(client, order);

                System.out.println(Constants.saleAdditionSuccess);
            }
            else {
                System.out.println(Constants.saleFail);
            }
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        } catch (ClientNotFoundException cnfe) {
            System.out.println(Constants.clientNotFound);

            AddClientCommand addClientCommand = new AddClientCommand(clients);

            addClientCommand.execute();
        }
    }

    private Map<Device, Integer> getOrder() {
        Map<Device, Integer> order = new TreeMap<>(new DeviceIdComparator());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern linePattern = Pattern.compile("\\d+\\s\\d+");

        try {
            Pair<Device, Integer> item = readOrderLine(reader, linePattern);

            while(item != null) {
                order.put(item.getKey(), item.getValue());

                item = readOrderLine(reader, linePattern);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WrongDataException e) {
            System.out.println(Constants.orderFail);

            return order;
        }
        return order;
    }

    private Pair<Device, Integer> readOrderLine(BufferedReader reader, Pattern pattern) throws IOException, WrongDataException {
        String input = reader.readLine();

        if(input.equals("-")) {
            return null;
        }

        Matcher matcher = pattern.matcher(input);

        boolean matches = matcher.matches();

        if (!matches) {
            throw new WrongDataException();
        }

        String[] position = input.split(" ");

        int deviceID = Integer.parseInt(position[0]);

        Device device = getDevice(deviceID);

        if(device == null) {
            return null;
        }
        else {
            int number = Integer.parseInt(position[1]);

            return new Pair<>(device, number);
        }
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

    private Device getDevice(int deviceID) {
        Device device = deviceSearcher.findByID(devices.getDeviceMap(), deviceID);
        if(device == null) {
            System.out.println(Constants.deviceNotFound);

            return null;
        }
        else {
            return device;
        }
    }
}
