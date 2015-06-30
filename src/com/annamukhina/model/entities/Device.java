package com.annamukhina.model.entities;

import com.annamukhina.model.enums.BrandOfDeviceEnum;
import com.annamukhina.model.enums.ColorOfDeviceEnum;
import com.annamukhina.model.enums.TypeOfDeviceEnum;
import com.annamukhina.view.Constants;

import java.util.Date;

/**
 * @author anna_mukhina
 */
public class Device {
    public static int lastID = 0;
    private final int id;
    private final BrandOfDeviceEnum.Brands brand;
    private final String model;
    private final TypeOfDeviceEnum.Types type;
    private final ColorOfDeviceEnum.Colors color;
    private Date releaseDate;

    public Device(BrandOfDeviceEnum.Brands brand, String model, TypeOfDeviceEnum.Types type,
                  ColorOfDeviceEnum.Colors color, Date releaseDate) {
        lastID++;
        this.id = lastID;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.color = color;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public BrandOfDeviceEnum.Brands getBrand() {
        return brand;
    }

    public TypeOfDeviceEnum.Types getType() {
        return type;
    }

    public ColorOfDeviceEnum.Colors getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return id + " " + brand.name() + " " + model + " " + type.name() + " "
                + color.name() + " " + Constants.format.format(releaseDate);
    }
}
