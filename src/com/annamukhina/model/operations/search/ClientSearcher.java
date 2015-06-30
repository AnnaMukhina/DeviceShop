package com.annamukhina.model.operations.search;

import com.annamukhina.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anna_mukhina
 */
public class ClientSearcher extends SearcherByID<Client> {
    public List<Client> findByFullName(String surname, String name, String middleName,
                                              List<Client> clients) {
        List<Client> found = new ArrayList<>();

        for (Client client : clients) {
            if(client.getSurname().equals(surname)) {
                if(client.getName().equals(name)) {
                    if (client.getMiddleName().equals(middleName)) {
                        found.add(client);
                    }
                }
            }
        }
        return found;
    }
}
