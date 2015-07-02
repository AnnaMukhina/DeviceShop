package com.annamukhina.controllers.client;

import com.annamukhina.model.entities.Client;
import com.annamukhina.model.operations.sorting.Sorter;
import com.annamukhina.model.operations.comparators.client.*;
import com.annamukhina.model.storages.Clients;

import java.util.List;

/**
 * @author anna_mukhina
 */
public class ClientsSortingController {
    private final Sorter<Client> sorter;
    private final List<Client> clientList;

    public ClientsSortingController(Clients clients) {
        this.sorter = new Sorter<>();
        this.clientList = clients.getClientList();
    }

    public List<Client> getSortedByID() {
        return sorter.getResultOfSort(clientList, new ClientIdComparator());
    }

    public List<Client> getSortedBySurname() {
        return sorter.getResultOfSort(clientList, new SurnameComparator());
    }

    public List<Client> getSortedByName() {
        return sorter.getResultOfSort(clientList, new NameComparator());
    }

    public List<Client> getSortedByMiddleName() {
        return  sorter.getResultOfSort(clientList, new MiddleNameComparator());
    }

    public List<Client> getSortedByYearOfBirth() {
        return sorter.getResultOfSort(clientList, new YearOfBirthComparator());
    }
}
