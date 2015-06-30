package com.annamukhina.view;

import java.util.Date;

/**
 * @author anna_mukhina
 */
public class Helper {
    private static boolean active = true;
    public static boolean breakMethod = false;
    public static int code;
    public static Date date;

    public static boolean isActive() {
        return active;
    }

    public static void setActive(boolean active) {
        Helper.active = active;
    }
}
