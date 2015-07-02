package com.annamukhina.view.commands;

import com.annamukhina.controllers.device.DevicesSortingController;
import com.annamukhina.model.entities.Device;
import com.annamukhina.model.storages.Devices;
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
public class SortDevicesCommand implements Command {
    private final DevicesSortingController devicesSortingController;
    private final String devicesSortingMenu;
    private final int MAXCODE = 6;
    private List<Device> result;

    public SortDevicesCommand(Devices devices) {
        this.devicesSortingController = new DevicesSortingController(devices);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите цифру, соответствующую параметру сортировки:\n");
        stringBuilder.append("1 - id, 2 - марка, 3 - тип, 4 - цвет, 5 - дата выпуска, 6 - модель");

        this.devicesSortingMenu = stringBuilder.toString();
    }

    @Override
    public void execute() {
        System.out.println(devicesSortingMenu);

        Scanner scanner = new Scanner(System.in);

        try {
            int parameterOfSort = InputReader.getCode(scanner, MAXCODE);

            switch (Constants.CODES[parameterOfSort]) {
                case ONE:
                    this.result = devicesSortingController.getSortedByID();
                    break;
                case TWO:
                    this.result = devicesSortingController.getSortedByBrand();
                    break;
                case THREE:
                    this.result = devicesSortingController.getSortedByType();
                    break;
                case FOUR:
                    this.result = devicesSortingController.getSortedByColor();
                    break;
                case FIVE:
                    this.result = devicesSortingController.getSortedByReleaseDate();
                    break;
                case SIX:
                    this.result = devicesSortingController.getSortedByModel();
                    break;
            }
            PrintCommand<Device> printCommand = new PrintCommand<>(result);

            printCommand.execute();

        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
