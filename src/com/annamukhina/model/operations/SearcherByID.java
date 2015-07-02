package com.annamukhina.model.operations;

import java.util.Map;

/**
 * @author anna_mukhina
 */
public class SearcherByID<T> {
    public T findByID(Map<Integer, T> map, int id) {
        return map.get(id);
    }
}
