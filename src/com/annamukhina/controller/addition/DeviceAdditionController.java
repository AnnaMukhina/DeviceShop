package com.annamukhina.controller.addition;

import com.annamukhina.model.entities.Device;
import com.annamukhina.model.enums.BrandOfDeviceEnum;
import com.annamukhina.model.enums.ColorOfDeviceEnum;
import com.annamukhina.model.enums.TypeOfDeviceEnum;
import com.annamukhina.model.storages.Devices;

import java.util.Date;

/**
 * @author anna_mukhina
 */
public class DeviceAdditionController {
    private final Devices devices;
    private final BrandOfDeviceEnum.Brands brands[];
    private final TypeOfDeviceEnum.Types types[];
    private final ColorOfDeviceEnum.Colors colors[];

    public DeviceAdditionController(Devices devices) {
        this.devices = devices;
        this.brands = BrandOfDeviceEnum.Brands.values();
        this.types = TypeOfDeviceEnum.Types.values();
        this.colors = ColorOfDeviceEnum.Colors.values();
    }

    public void addDevice(int codeOfBrand, String model, int codeOfType, int codeOfColor, Date releaseDate) {
        BrandOfDeviceEnum.Brands brand = brands[codeOfBrand];

        TypeOfDeviceEnum.Types type = types[codeOfType];

        ColorOfDeviceEnum.Colors color = colors[codeOfColor];

        Device newDevice = new Device(brand, model, type, color, releaseDate);

        devices.addDevice(newDevice);
    }
}
