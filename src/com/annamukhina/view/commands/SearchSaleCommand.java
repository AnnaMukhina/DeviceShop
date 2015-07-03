package com.annamukhina.view.commands;

import com.annamukhina.controllers.sale.SaleSearchController;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.InputReader;
import com.annamukhina.view.MainMenu;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

import java.util.Scanner;

/**
 * @author anna_mukhina
 *
 * Calls methods for user input reading and check,
 * creates controller for the search of sales,
 * calls it's methods for search, calls Print command for the results of the search.
 */
public class SearchSaleCommand implements Command {
    private final SaleSearchController saleSearchController;
    private final String MESSAGE = "Введите год продажи:";
    private int year;

    public SearchSaleCommand(Sales sales) {
        this.saleSearchController = new SaleSearchController(sales);
    }

    @Override
    public void execute() {
        System.out.println(MESSAGE);

        Scanner scanner = new Scanner(System.in);

        try {
            this.year = InputReader.getYear(scanner);

            saleSearchController.findByYear(year);
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
