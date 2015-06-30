package com.annamukhina.view.commands;

import com.annamukhina.controller.sorting.DevicesSortingController;
import com.annamukhina.model.entities.Device;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.view.Constants;

import java.util.List;
import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class SortDevicesCommand implements Command {
    private final Devices devices;
    private final DevicesSortingController devicesSortingController;
    private final String devicesSortingMenu;
    private List<Device> result;

    public SortDevicesCommand(Devices devices) {
        this.devices = devices;
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

        String parameterOfSort = scanner.next();

        switch (parameterOfSort) {
            case "1":
                this.result = devicesSortingController.getSortedByID();
                break;
            case "2":
                this.result = devicesSortingController.getSortedByBrand();
                break;
            case "3":
                this.result = devicesSortingController.getSortedByType();
                break;
            case "4":
                this.result = devicesSortingController.getSortedByColor();
                break;
            case "5":
                this.result = devicesSortingController.getSortedByReleaseDate();
                break;
            case "6":
                this.result = devicesSortingController.getSortedByModel();
                break;
            case "menu":
                break;
            case "exit":
                break;
            default:
                System.out.println(Constants.fail);
                execute();
        }

        PrintCommand<Device> printCommand = new PrintCommand<>(result);

        printCommand.execute();
    }
}
