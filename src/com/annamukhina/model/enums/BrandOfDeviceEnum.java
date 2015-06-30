package com.annamukhina.model.enums;

/**
 * @author anna_mukhina
 */
public class BrandOfDeviceEnum {
    public static enum Brands {
        ACER, APPLE, ASUS, HTC, LG, SAMSUNG, SONY;

        @Override
        public String toString() {
            return this.ordinal() + " - " + this.name() + "; ";
        }
    }

    public static void printBrands() {
        for (Brands brands : Brands.values()) {
            System.out.print(brands.toString() + " ");
        }
        System.out.println();
    }
}
