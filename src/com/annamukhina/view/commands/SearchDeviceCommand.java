package com.annamukhina.view.commands;

import com.annamukhina.controllers.device.DeviceSearchController;
import com.annamukhina.model.enums.BrandOfDeviceEnum;
import com.annamukhina.model.enums.TypeOfDeviceEnum;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;
import com.annamukhina.view.MainMenu;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class SearchDeviceCommand implements Command {
    private final DeviceSearchController deviceSearchController;
    private final String deviceSearchMenu;
    private int code;
    private int releaseYear;

    public SearchDeviceCommand(Devices devices) {
        this.deviceSearchController = new DeviceSearchController(devices);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выберите цифру, соответствующую параметру поиска:\n");
        stringBuilder.append("1 - id, 2 - марка, 3 - тип, 4 - год выпуска");

        this.deviceSearchMenu = stringBuilder.toString();
    }


    @Override
    public void execute() {
        System.out.println(deviceSearchMenu);

        Scanner scanner = new Scanner(System.in);

        try {
            int parameterOfSearch = InputReader.getCode(scanner, 4);
            switch (parameterOfSearch) {
                case 1:
                    System.out.println(Constants.deviceIdInput);

                    this.code = InputReader.getCode(scanner, Constants.maxDeviceID);

                    deviceSearchController.findByID(code);

                    break;
                case 2:
                    System.out.println(Constants.brandInput);

                    BrandOfDeviceEnum.printBrands();

                    this.code = InputReader.getCode(scanner, Constants.maxCodeOfBrand);

                    deviceSearchController.findByBrand(code);

                    break;
                case 3:
                    System.out.println(Constants.typeInput);

                    TypeOfDeviceEnum.printTypes();

                    this.code = InputReader.getCode(scanner, Constants.maxCodeOfType);

                    deviceSearchController.findByType(code);

                    break;
                case 4:
                    System.out.println(Constants.deviceReleaseYearInput);

                    this.releaseYear = InputReader.getYear(scanner);

                    deviceSearchController.findByReleaseYear(releaseYear);

                    break;
                default:
                    System.out.println(Constants.fail);

                    execute();
            }
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
