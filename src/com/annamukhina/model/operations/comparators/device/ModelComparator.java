package com.annamukhina.model.operations.comparators.device;

import com.annamukhina.model.entities.Device;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class ModelComparator implements Comparator<Device> {
    public int compare(Device device1, Device device2) {
        String model1 = device1.getModel();
        String model2 = device2.getModel();

        return model1.compareTo(model2);
    }
}
