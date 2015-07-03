package com.annamukhina.model.operations;

import com.annamukhina.model.entities.Device;
import com.annamukhina.model.enums.BrandOfDeviceEnum;
import com.annamukhina.model.enums.TypeOfDeviceEnum;

import java.util.*;

/**
 * @author anna_mukhina
 *
 * Contains methods for the search of the devices.
 */
public class DeviceSearcher extends SearcherByID<Device> {
    /**
     * Searches for the devices by code of the brand.
     * Returns a list of the Device objects with specified parameter.
     * If there are no devices with this brand returns an empty list.
     *
     * @param brand brand of the device code in enum
     * @param devices list of values of the map-storage
     * @return list of the Device objects with this brand
     */
    public List<Device> findByBrand(int brand, List<Device> devices) {
        BrandOfDeviceEnum.Brand brands[] = BrandOfDeviceEnum.Brand.values();

        List<Device> found = new ArrayList<>();

        for (Device device : devices) {
           if(device.getBrand() == brands[brand]) {
                found.add(device);
            }
        }
        return found;
    }
    /**
     * Searches for the devices by code of the type.
     * Returns a list of the Device objects with specified parameter.
     * If there are no devices with this type returns an empty list.
     *
     * @param type type of the device code in enum
     * @param devices list of values of the map-storage
     * @return list of the Device objects with this type
     */
    public List<Device> findByType(int type, List<Device> devices) {
        TypeOfDeviceEnum.Type types[] = TypeOfDeviceEnum.Type.values();

        List<Device> found = new ArrayList<>();

        for (Device device : devices) {
            if(device.getType() == types[type]) {
                found.add(device);
            }
        }
        return found;
    }
    /**
     * Searches for the devices by release year.
     * Returns a list of the Device objects with specified parameter.
     * If there are no devices with this release year returns an empty list.
     *
     * @param releaseYear release year of the device
     * @param devices list of values of the map-storage
     * @return list of the Device objects with this release year
     */
    public List<Device> findByReleaseYear(int releaseYear, List<Device> devices) {
        List<Device> found = new ArrayList<>();

        Calendar patternDate = Calendar.getInstance();
        Calendar dateToCompare = Calendar.getInstance();

        patternDate.set(Calendar.YEAR, releaseYear);

        for (Device device : devices) {
            Date date = device.getReleaseDate();

            dateToCompare.setTime(date);

            if(patternDate.get(Calendar.YEAR) == dateToCompare.get(Calendar.YEAR)) {
                found.add(device);
            }
        }
        return found;
    }

    /**
     * Method for tests.
     * Searches for the devices by model.
     * Returns a list of the Device objects with specified parameter.
     * If there are no devices with this model returns an empty list.
     *
     * @param desiredModel model of the device
     * @param devices list of values of the map-storage
     * @return list of the Device objects with this model
     */
    public List<Device> findByModel(String desiredModel, List<Device> devices) {
        List<Device> found = new ArrayList<>();

        for(Device device : devices) {
            String model = device.getModel();

            if(model.equals(desiredModel)) {
                found.add(device);
            }
        }
        return found;
    }
}
