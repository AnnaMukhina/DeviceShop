package com.annamukhina.controllers.device;

import com.annamukhina.model.entities.Device;
import com.annamukhina.model.enums.BrandOfDeviceEnum;
import com.annamukhina.model.enums.ColorOfDeviceEnum;
import com.annamukhina.model.enums.TypeOfDeviceEnum;
import com.annamukhina.model.storages.Devices;

import java.util.Date;

/**
 * @author anna_mukhina
 *
 * Controller for device addition to Devices storage.
 */
public class DeviceAdditionController {
    private final Devices devices;
    private final BrandOfDeviceEnum.Brand brands[];
    private final TypeOfDeviceEnum.Type types[];
    private final ColorOfDeviceEnum.Color colors[];

    public DeviceAdditionController(Devices devices) {
        this.devices = devices;
        this.brands = BrandOfDeviceEnum.Brand.values();
        this.types = TypeOfDeviceEnum.Type.values();
        this.colors = ColorOfDeviceEnum.Color.values();
    }

    /**
     * Calls method for device addition from Model.
     *
     * @param codeOfBrand code of the brand of device in enum
     * @param model model of the device
     * @param codeOfType code of the type of device in enum
     * @param codeOfColor code of the color of device in enum
     * @param releaseDate date of device release
     */
    public void addDevice(int codeOfBrand, String model, int codeOfType, int codeOfColor, Date releaseDate) {
        BrandOfDeviceEnum.Brand brand = brands[codeOfBrand];

        TypeOfDeviceEnum.Type type = types[codeOfType];

        ColorOfDeviceEnum.Color color = colors[codeOfColor];

        Device newDevice = new Device(brand, model, type, color, releaseDate);

        devices.addDevice(newDevice);
    }
}
