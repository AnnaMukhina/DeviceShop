package com.annamukhina.view;

/**
 * @author anna_mukhina
 */
public class MainMenu {
    public static StringBuilder menu;

    public MainMenu() {
        this.menu  = new StringBuilder();

        menu.append("Вы находитесь в главном меню\n");
        menu.append("--------------------------------------------------------\n");
        menu.append("Список доступных команд:\n");
        menu.append("client     внесение в базу нового клиента\n");
        menu.append("device     добавление в ассортимент нового девайса\n");
        menu.append("sale       оформление покупки\n");
        menu.append("search     переход к поиску\n");
        menu.append("sort       переход к сортировкам\n");
        menu.append("exit       завершение работы с системой\n");
        menu.append("--------------------------------------------------------");
    }

    public static void showMenu() {
        System.out.println("hey");
    }
}
