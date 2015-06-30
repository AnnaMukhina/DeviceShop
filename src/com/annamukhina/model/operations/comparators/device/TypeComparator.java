package com.annamukhina.model.operations.comparators.device;

import com.annamukhina.model.entities.Device;
import com.annamukhina.model.enums.TypeOfDeviceEnum;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class TypeComparator implements Comparator<Device> {
    public int compare(Device device1, Device device2) {
        TypeOfDeviceEnum.Types type1 = device1.getType();
        TypeOfDeviceEnum.Types type2 = device2.getType();

        return type1.compareTo(type2);
    }
}
