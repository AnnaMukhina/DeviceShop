package com.annamukhina.view;

/**
 * @author anna_mukhina
 */
public class MainMenu {
    private static String menu;

    public MainMenu() {
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

        this.menu = stringBuilder.toString();
    }

    public static void showMenu() {
        System.out.println(menu);
    }
}
