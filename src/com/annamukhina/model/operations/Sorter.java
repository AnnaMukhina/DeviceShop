package com.annamukhina.model.operations;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author anna_mukhina
 *
 * Contains method for the objects sorting.
 */
public class Sorter<T> {
    /**
     * Sorts list of the objects using comparator.
     * Returns sorted list of the objects.
     *
     * @param valueList list of values of the map-storage
     * @param comparator comparator
     * @return sorted list of the objects
     */
    public  List<T> getResultOfSort(List<T> valueList, Comparator<T> comparator) {
        Collections.sort(valueList, comparator);

        return valueList;
    }
}
