package com.annamukhina.model.operations;

import com.annamukhina.model.entities.Client;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author anna_mukhina
 *
 * Contains methods for the search of the clients.
 */
public class ClientSearcher extends SearcherByID<Client> {
    /**
     * Searches for the clients by surname, name and middle name.
     * Returns list of the Client objects with this parameters.
     * If there are no clients with this parameters returns an empty list.
     *
     * @param surname client's surname
     * @param name client's name
     * @param middleName client's middle name
     * @param clients list of values of the map-storage
     * @return list of the Client objects with this parameters
     */
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

    /**
     * Method for tests.
     * Searches for the clients by year of birth.
     * Returns list of the Client objects with this parameter.
     * If there are no clients with this parameter returns an empty list.
     * @param year year of birth
     * @param clients list of values of the map-storage
     * @return list of the Client objects with this parameter
     */
    public List<Client> findByYearOfBirth(int year, List<Client> clients) {
        List<Client> found = new ArrayList<>();

        Calendar patternDate = Calendar.getInstance();
        Calendar dateToCompare = Calendar.getInstance();

        patternDate.set(Calendar.YEAR, year);

        for (Client client : clients) {
            Date date = client.getDateOfBirth();

            dateToCompare.setTime(date);

            if(patternDate.get(Calendar.YEAR) == dateToCompare.get(Calendar.YEAR)) {
                found.add(client);
            }
        }
        return found;
    }
}
