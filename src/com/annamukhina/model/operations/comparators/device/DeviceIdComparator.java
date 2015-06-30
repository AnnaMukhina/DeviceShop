package com.annamukhina.model.operations.comparators.device;

import com.annamukhina.model.entities.Device;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class DeviceIdComparator implements Comparator<Device> {
    public int compare(Device device1, Device device2) {
        int id1 = device1.getId();
        int id2 = device2.getId();

        return id1 - id2;
    }
}
