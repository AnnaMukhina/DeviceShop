package com.annamukhina.controllers.device;

import com.annamukhina.model.entities.Device;
import com.annamukhina.model.operations.Sorter;
import com.annamukhina.model.operations.comparators.device.*;
import com.annamukhina.model.storages.Devices;

import java.util.List;

/**
 * @author anna_mukhina
 *
 * Controller for devices sorting.
 */
public class DevicesSortingController {
    private  final Sorter<Device> sorter; //contains methods for sorting
    private final List<Device> deviceList; //List of values of the map-storage

    public DevicesSortingController(Devices devices) {
        this.sorter = new Sorter<>();
        this.deviceList = devices.getDeviceList();
    }

    /**
     * Calls method for devices sorting by id from Model.
     *
     * @return sorted by id list of the Device objects
     */
    public List<Device> getSortedByID() {
        return sorter.getResultOfSort(deviceList, new DeviceIdComparator());
    }

    /**
     * Calls method for devices sorting by brand from Model.
     *
     * @return sorted by brand list of the Device objects
     */
    public List<Device> getSortedByBrand() {
        return sorter.getResultOfSort(deviceList, new BrandComparator());
    }
    /**
     * Calls method for devices sorting by type from Model.
     *
     * @return sorted by type list of the Device objects
     */
    public List<Device> getSortedByType() {
        return sorter.getResultOfSort(deviceList, new TypeComparator());
    }
    /**
     * Calls method for devices sorting by color from Model.
     *
     * @return sorted by color list of the Device objects
     */
    public List<Device> getSortedByColor() {
        return sorter.getResultOfSort(deviceList, new ColorComparator());
    }
    /**
     * Calls method for devices sorting by release date from Model.
     *
     * @return sorted by release date list of the the Device objects
     */
    public List<Device> getSortedByReleaseDate() {
        return sorter.getResultOfSort(deviceList, new ReleaseDateComparator());
    }
    /**
     * Calls method for devices sorting by model from Model.
     *
     * @return sorted by model list of the the Device objects
     */
    public List<Device> getSortedByModel() {
        return sorter.getResultOfSort(deviceList, new ModelComparator());
    }
}
