package com.annamukhina.controllers.device;

import com.annamukhina.model.entities.Device;
import com.annamukhina.model.operations.Sorter;
import com.annamukhina.model.operations.comparators.device.*;
import com.annamukhina.model.storages.Devices;

import java.util.List;

/**
 * @author anna_mukhina
 */
public class DevicesSortingController {
    private  final Sorter<Device> sorter;
    private final List<Device> deviceList;

    public DevicesSortingController(Devices devices) {
        this.sorter = new Sorter<>();
        this.deviceList = devices.getDeviceList();
    }

    public List<Device> getSortedByID() {
        return sorter.getResultOfSort(deviceList, new DeviceIdComparator());
    }

    public List<Device> getSortedByBrand() {
        return sorter.getResultOfSort(deviceList, new BrandComparator());
    }

    public List<Device> getSortedByType() {
        return sorter.getResultOfSort(deviceList, new TypeComparator());
    }

    public List<Device> getSortedByColor() {
        return sorter.getResultOfSort(deviceList, new ColorComparator());
    }

    public List<Device> getSortedByReleaseDate() {
        return sorter.getResultOfSort(deviceList, new ReleaseDateComparator());
    }

    public List<Device> getSortedByModel() {
        return sorter.getResultOfSort(deviceList, new ModelComparator());
    }
}
