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
    private final BrandOfDeviceEnum.Brand brand;
    private final String model;
    private final TypeOfDeviceEnum.Type type;
    private final ColorOfDeviceEnum.Color color;
    private Date releaseDate;

    public Device(BrandOfDeviceEnum.Brand brand, String model, TypeOfDeviceEnum.Type type,
                  ColorOfDeviceEnum.Color color, Date releaseDate) {
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

    public BrandOfDeviceEnum.Brand getBrand() {
        return brand;
    }

    public TypeOfDeviceEnum.Type getType() {
        return type;
    }

    public ColorOfDeviceEnum.Color getColor() {
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
