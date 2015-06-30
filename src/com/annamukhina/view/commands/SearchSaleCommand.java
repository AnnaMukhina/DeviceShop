package com.annamukhina.view.commands;

import com.annamukhina.controller.search.SaleSearchController;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.InputReader;

import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class SearchSaleCommand implements Command {
    private final Sales sales;
    private final SaleSearchController saleSearchController;
    private final String MESSAGE = "Введите год продажи:";
    private int year;

    public SearchSaleCommand(Sales sales) {
        this.sales = sales;
        this.saleSearchController = new SaleSearchController(sales);
    }

    @Override
    public void execute() {
        System.out.println(MESSAGE);

        Scanner scanner = new Scanner(System.in);

        this.year = InputReader.getYear(scanner);

        saleSearchController.findByYear(year);
    }
}
