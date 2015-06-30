package com.annamukhina.model.operations.comparators.device;

import com.annamukhina.model.entities.Device;

import java.util.Comparator;
import java.util.Date;

/**
 * @author anna_mukhina
 */
public class ReleaseDateComparator implements Comparator<Device> {
    public int compare(Device device1, Device device2) {
        Date releaseDate1 = device1.getReleaseDate();
        Date releaseDate2 = device2.getReleaseDate();

        return releaseDate1.compareTo(releaseDate2);
    }
}
