package com.annamukhina.model.operations.comparators.device;

import com.annamukhina.model.enums.BrandOfDeviceEnum;
import com.annamukhina.model.entities.Device;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class BrandComparator implements Comparator<Device> {
    public int compare(Device device1, Device device2) {
        BrandOfDeviceEnum.Brand brand1 = device1.getBrand();
        BrandOfDeviceEnum.Brand brand2 = device2.getBrand();

        return brand1.compareTo(brand2);
    }
}
