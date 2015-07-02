package com.annamukhina.model.enums;

/**
 * @author anna_mukhina
 */
public class BrandOfDeviceEnum {
    public static enum Brand {
        ACER, APPLE, ASUS, HTC, LG, SAMSUNG, SONY;

        @Override
        public String toString() {
            return this.ordinal() + " - " + this.name() + "; ";
        }
    }

    public static void printBrands() {
        for (Brand brand : Brand.values()) {
            System.out.print(brand.toString() + " ");
        }
        System.out.println();
    }
}
