package com.annamukhina.controllers.client;

import com.annamukhina.model.entities.Client;
import com.annamukhina.model.operations.ClientSearcher;
import com.annamukhina.model.storages.Clients;

import java.util.List;
import java.util.Map;

/**
 * @author anna_mukhina
 *
 * Controller for search of the clients.
 */
public class ClientSearchController {
    private final Clients clients;
    private final ClientSearcher clientSearcher; //contains methods for client search
    private final Map<Integer, Client> clientMap; //storage

    public ClientSearchController(Clients clients) {
        this.clients = clients;
        this.clientSearcher = new ClientSearcher();
        this.clientMap = clients.getClientsMap();
    }

    /**
     * Calls method for search of the clients by surname, name and middle name from Model.
     * Returns a Client object with specified parameters or null, if this client
     * doesn't exist.
     *
     * @param surname client's surname
     * @param name client's name
     * @param middleName client's middle name
     * @return Client object
     */
    public List<Client> findByFullName(String surname, String name, String middleName) {
        List<Client> clientsList = clients.getClientList();
        return clientSearcher.findByFullName(surname, name, middleName, clientsList);
    }

    /**
     * Calls method for search of the clients by id from Model.
     * Returns a Client object with specified parameter or null, if this client
     * doesn't exist.
     *
     * @param id client's id
     * @return Client object
     */
    public Client findByID(int id) {
        return clientSearcher.findByID(clientMap, id);
    }

    /**
     * Method for tests.
     * Calls method for search of the clients by year of birth from Model.
     * Returns a Client object with specified parameter or null, if there are no clients born
     * in this year.
     * @param year year of birth
     * @return list of the clients with this year of birth
     */
    public List<Client> findByYearOfBirth(int year) {
        List<Client> clientsList = clients.getClientList();

        return clientSearcher.findByYearOfBirth(year, clientsList);
    }
}
