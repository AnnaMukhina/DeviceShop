package com.annamukhina.model.enums;

/**
 * @author anna_mukhina
 */
public class ColorOfDeviceEnum {
    public enum Color {
        BLACK, BLUE, GREEN, RED, WHITE, YELLOW;

        @Override
        public String toString() {
            return this.ordinal() + " - " + this.name() + "; ";
        }
    }

    public static void printColors() {
        for (Color color : Color.values()) {
            System.out.print(color.toString() + " ");
        }
        System.out.println();
    }
}
