package com.annamukhina.model.operations;

import com.annamukhina.model.entities.Device;
import com.annamukhina.model.enums.BrandOfDeviceEnum;
import com.annamukhina.model.enums.TypeOfDeviceEnum;

import java.util.*;

/**
 * @author anna_mukhina
 */
public class DeviceSearcher extends SearcherByID<Device> {
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

    public List<Device> findByReleaseYear(int desiredYear, List<Device> devices) {
        List<Device> found = new ArrayList<>();

        Calendar patternDate = Calendar.getInstance();
        Calendar dateToCompare = Calendar.getInstance();

        patternDate.set(Calendar.YEAR, desiredYear);

        for (Device device : devices) {
            Date date = device.getReleaseDate();

            dateToCompare.setTime(date);

            if(patternDate.get(Calendar.YEAR) == dateToCompare.get(Calendar.YEAR)) {
                found.add(device);
            }
        }
        return found;
    }
}
