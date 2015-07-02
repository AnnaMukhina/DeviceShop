package com.annamukhina.model.operations;

import java.util.Map;

/**
 * @author anna_mukhina
 *
 * Contains method for the search of instance by id.
 */
public class SearcherByID<T> {
    /**
     * Searches for an instance by id.
     *
     * @param map storage (Clients, Devices or Sales)
     * @param id instance id
     * @return instance object (Client, Device or Sale) with this id
     */
    public T findByID(Map<Integer, T> map, int id) {
        return map.get(id);
    }
}
