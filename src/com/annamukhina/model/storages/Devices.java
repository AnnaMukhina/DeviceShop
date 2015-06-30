package com.annamukhina.model.storages;

import com.annamukhina.model.entities.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author anna_mukhina
 */
public class Devices {
    private Map<Integer, Device> devices;

    public Devices() {
        devices = new TreeMap<>();
    }

    public Map<Integer, Device> getDeviceMap() {
        return devices;
    }

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
    }

    public List<Device> getDeviceList() {
        return new ArrayList<>(devices.values());
    }
}
