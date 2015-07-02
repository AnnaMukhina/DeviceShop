package com.annamukhina.controllers.device;

import com.annamukhina.model.entities.Device;
import com.annamukhina.model.operations.DeviceSearcher;
import com.annamukhina.model.storages.Devices;

import java.util.List;

/**
 * @author anna_mukhina
 *
 * Controller for devices search.
 */
public class DeviceSearchController {
    private final Devices devices; //storage
    private final DeviceSearcher deviceSearcher; //contains methods for devices search

    public DeviceSearchController(Devices devices) {
        this.devices = devices;
        this.deviceSearcher = new DeviceSearcher();
    }

    /**
     * Calls method for device search by id from Model.
     * Returns a Device object with specified parameter or null, if this device
     * with this id doesn't exist.
     *
     * @param id id of the device
     * @return Device object
     */
    public Device findByID(int id) {
        return deviceSearcher.findByID(devices.getDeviceMap(), id);
    }

    /**
     * Calls method for devices search by brand from Model.
     * Returns a list of the Device objects with specified parameter.
     * If there are no devices with this brand returns an empty list.
     *
     * @param brand brand of the device code in enum
     * @return list of the devices with this brand
     */
    public List<Device> findByBrand(int brand) {
        return deviceSearcher.findByBrand(brand, devices.getDeviceList());
    }

    /**
     * Calls method for devices search by type from Model.
     * Returns a list of the Device objects with specified parameter.
     * If there are no devices with this type returns an empty list.
     *
     * @param type type of the device code in enum
     * @return list of the devices with this type
     */
    public List<Device> findByType(int type) {
        return deviceSearcher.findByType(type, devices.getDeviceList());
    }

    /**
     * Calls method for device search by release year from Model.
     * Returns a list of the Device objects with specified parameter.
     * If there are no devices released in this year returns an empty list.
     *
     * @param year year of the device release
     * @return list of the devices released in this year
     */
    public List<Device> findByReleaseYear(int year) {
        return deviceSearcher.findByReleaseYear(year, devices.getDeviceList());
    }
}
