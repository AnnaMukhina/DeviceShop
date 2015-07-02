package com.annamukhina.model.enums;

/**
 * @author anna_mukhina
 */
public class TypeOfDeviceEnum {
    public enum Type {
        NOTEBOOK, PHONE, PLAYER, TABLET;

        @Override
        public String toString() {
            return this.ordinal() + " - " + this.name() + "; ";
        }
    }

    public static void printTypes() {
        for (Type type : Type.values()) {
            System.out.print(type.toString() + " ");
        }
        System.out.println();
    }
}
