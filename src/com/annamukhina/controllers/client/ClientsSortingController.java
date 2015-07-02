package com.annamukhina.controllers.client;

import com.annamukhina.model.entities.Client;
import com.annamukhina.model.operations.Sorter;
import com.annamukhina.model.operations.comparators.client.*;
import com.annamukhina.model.storages.Clients;

import java.util.List;

/**
 * @author anna_mukhina
 *
 * Controller for clients sorting.
 */
public class ClientsSortingController {
    private final Sorter<Client> sorter; //contains methods for sorting
    private final List<Client> clientList; //List of values of the map-storage

    public ClientsSortingController(Clients clients) {
        this.sorter = new Sorter<>();
        this.clientList = clients.getClientList();
    }

    /**
     * Calls method for clients sorting by id from Model.
     *
     * @return sorted by id list of the Client objects
     */
    public List<Client> getSortedByID() {
        return sorter.getResultOfSort(clientList, new ClientIdComparator());
    }
    /**
     * Calls method for clients sorting by surname from Model.
     *
     * @return sorted by surname list of the Client objects
     */
    public List<Client> getSortedBySurname() {
        return sorter.getResultOfSort(clientList, new SurnameComparator());
    }
    /**
     * Calls method for clients sorting by name from Model.
     *
     * @return sorted by name list of the Client objects
     */
    public List<Client> getSortedByName() {
        return sorter.getResultOfSort(clientList, new NameComparator());
    }
    /**
     * Calls method for clients sorting by middle name from Model.
     *
     * @return sorted by middle name list of the Client objects
     */
    public List<Client> getSortedByMiddleName() {
        return  sorter.getResultOfSort(clientList, new MiddleNameComparator());
    }
    /**
     * Calls method for clients sorting by year of birth from Model.
     *
     * @return sorted by year of birth list of the Client objects
     */
    public List<Client> getSortedByYearOfBirth() {
        return sorter.getResultOfSort(clientList, new YearOfBirthComparator());
    }
}
