package com.annamukhina.model.enums;

/**
 * @author anna_mukhina
 */
public class TypeOfDeviceEnum {
    public enum Types {
        NOTEBOOK, PHONE, PLAYER, TABLET;

        @Override
        public String toString() {
            return this.ordinal() + " - " + this.name() + "; ";
        }
    }

    public static void printTypes() {
        for (Types types : Types.values()) {
            System.out.print(types.toString() + " ");
        }
        System.out.println();
    }
}
