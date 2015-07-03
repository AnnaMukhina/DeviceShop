package com.annamukhina.view;

/**
 * @author anna_mukhina
 */
public class MainMenu {
    private static String menu;
    private static boolean active = true; //application works while is true

    public static void createMenu() {
        StringBuilder stringBuilder  = new StringBuilder();

        stringBuilder.append("Вы находитесь в главном меню\n");
        stringBuilder.append("--------------------------------------------------------\n");
        stringBuilder.append("Список доступных команд:\n");
        stringBuilder.append("client     внесение в базу нового клиента\n");
        stringBuilder.append("device     добавление в ассортимент нового девайса\n");
        stringBuilder.append("sale       оформление покупки\n");
        stringBuilder.append("search     переход к поиску\n");
        stringBuilder.append("sort       переход к сортировкам\n");
        stringBuilder.append("exit       завершение работы с системой\n");
        stringBuilder.append("--------------------------------------------------------");

        menu = stringBuilder.toString();
    }

    /**
     * Shows main menu of the application.
     */
    public static void showMenu() {
        System.out.println(menu);
    }

    public static boolean isActive() {
        return active;
    }

    public static void setActive(boolean active) {
        MainMenu.active = active;
    }
}
