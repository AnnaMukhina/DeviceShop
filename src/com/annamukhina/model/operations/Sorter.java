package com.annamukhina.model.operations;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author anna_mukhina
 */
public class Sorter<T> {
    public  List<T> getResultOfSort(List<T> valueList, Comparator<T> comparator) {
        Collections.sort(valueList, comparator);

        return valueList;
    }
}
