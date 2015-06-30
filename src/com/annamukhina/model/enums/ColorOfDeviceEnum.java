package com.annamukhina.model.enums;

/**
 * @author anna_mukhina
 */
public class ColorOfDeviceEnum {
    public enum Colors {
        BLACK, BLUE, GREEN, RED, WHITE, YELLOW;

        @Override
        public String toString() {
            return this.ordinal() + " - " + this.name() + "; ";
        }
    }

    public static void printColors() {
        for (Colors colors : Colors.values()) {
            System.out.print(colors.toString() + " ");
        }
        System.out.println();
    }
}
