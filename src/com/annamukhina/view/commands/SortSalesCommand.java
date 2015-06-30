package com.annamukhina.view.commands;

import com.annamukhina.controller.sorting.SalesSortingController;
import com.annamukhina.model.entities.Sale;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.Constants;

import java.util.List;
import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class SortSalesCommand implements Command {
    private final Sales sales;
    private final SalesSortingController salesSortingController;
    private final String salesSortingMenu;
    private List<Sale> result;

    public SortSalesCommand(Sales sales) {
        this.sales = sales;
        this.salesSortingController = new SalesSortingController(sales);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите цифру, соответствующую параметру сортировки:\n");
        stringBuilder.append("1 - id, 2 - дата, 3 - количество позиций, 4 - клиент");

        this.salesSortingMenu = stringBuilder.toString();
    }

    @Override
    public void execute() {
        System.out.println(salesSortingMenu);

        Scanner scanner = new Scanner(System.in);

        String parameterOfSort = scanner.next();

        switch (parameterOfSort) {
            case "1":
                salesSortingController.getSortedByID(); break;
            case "2":
                salesSortingController.getSortedByDate(); break;
            case "3":
                salesSortingController.getSortedByOrderSize(); break;
            case "4":
                salesSortingController.getSortedByClientID(); break;
            case "menu":
                break;
            case "exit":
                break;
            default:
                System.out.println(Constants.fail);
                execute();
        }

        PrintCommand<Sale> printCommand = new PrintCommand<>(result);

        printCommand.execute();
    }
}
