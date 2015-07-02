package com.annamukhina.model.operations.comparators.device;

import com.annamukhina.model.enums.ColorOfDeviceEnum;
import com.annamukhina.model.entities.Device;

import java.util.Comparator;

/**
 * @author anna_mukhina
 */
public class ColorComparator implements Comparator<Device> {
    public int compare(Device device1, Device device2) {
        ColorOfDeviceEnum.Color color1 = device1.getColor();
        ColorOfDeviceEnum.Color color2 = device2.getColor();

        return color1.compareTo(color2);
    }
}
