package com.annamukhina.controllers.device;

import com.annamukhina.model.entities.Device;
import com.annamukhina.model.operations.search.DeviceSearcher;
import com.annamukhina.model.storages.Devices;

import java.util.List;

/**
 * @author anna_mukhina
 */
public class DeviceSearchController {
    private final Devices devices;
    private final DeviceSearcher deviceSearcher;

    public DeviceSearchController(Devices devices) {
        this.devices = devices;
        this.deviceSearcher = new DeviceSearcher();
    }

    public Device findByID(int id) {
        return deviceSearcher.findByID(devices.getDeviceMap(), id);
    }

    public List<Device> findByBrand(int brand) {
        return deviceSearcher.findByBrand(brand, devices.getDeviceList());
    }

    public List<Device> findByType(int type) {
        return deviceSearcher.findByType(type, devices.getDeviceList());
    }

    public List<Device> findByReleaseYear(int year) {
        return deviceSearcher.findByReleaseYear(year, devices.getDeviceList());
    }
}
