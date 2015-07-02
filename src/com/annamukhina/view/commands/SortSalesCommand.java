package com.annamukhina.view.commands;

import com.annamukhina.controllers.sale.SalesSortingController;
import com.annamukhina.model.entities.Sale;
import com.annamukhina.model.storages.Sales;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;
import com.annamukhina.view.MainMenu;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

import java.util.List;
import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class SortSalesCommand implements Command {
    private final SalesSortingController salesSortingController;
    private final String salesSortingMenu;
    private final int MAXCODE = 4;
    private List<Sale> result;

    public SortSalesCommand(Sales sales) {
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

        try {
            int parameterOfSort = InputReader.getCode(scanner, MAXCODE);

            switch (Constants.codes[parameterOfSort]) {
                case ONE:
                    this.result = salesSortingController.getSortedByID(); break;
                case TWO:
                    this.result = salesSortingController.getSortedByDate(); break;
                case THREE:
                    this.result = salesSortingController.getSortedByOrderSize(); break;
                case FOUR:
                    this.result = salesSortingController.getSortedByClientID(); break;
                default:
                    System.out.println(Constants.fail);

                    execute();
            }
            PrintCommand<Sale> printCommand = new PrintCommand<>(result);

            printCommand.execute();
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
