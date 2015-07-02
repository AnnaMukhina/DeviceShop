package com.annamukhina.view.commands;

import com.annamukhina.controllers.device.DeviceAdditionController;
import com.annamukhina.model.enums.BrandOfDeviceEnum;
import com.annamukhina.model.enums.ColorOfDeviceEnum;
import com.annamukhina.model.enums.TypeOfDeviceEnum;
import com.annamukhina.model.storages.Devices;
import com.annamukhina.view.Constants;
import com.annamukhina.view.InputReader;
import com.annamukhina.view.MainMenu;
import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;

import java.util.Date;
import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class AddDeviceCommand implements Command {
    private final DeviceAdditionController deviceAdditionController;
    private final StringBuilder deviceAdditionMenu;

    public AddDeviceCommand(Devices devices) {
        this.deviceAdditionController = new DeviceAdditionController(devices);
        this.deviceAdditionMenu = new StringBuilder();

        deviceAdditionMenu.append("\n");
        deviceAdditionMenu.append("Для возврата в главное меню введите menu\n");
        deviceAdditionMenu.append("Для завершения работы с системой введите exit\n");
        deviceAdditionMenu.append("--------------------------------------------------------\n");
        deviceAdditionMenu.append("Добавление в ассортимент нового девайса\n");
        deviceAdditionMenu.append("--------------------------------------------------------");
    }

    public void execute() {
        System.out.println(deviceAdditionMenu);

        System.out.println(Constants.brandInput);

        BrandOfDeviceEnum.printBrands();

        Scanner scanner = new Scanner(System.in);

        try {
            int codeOfBrand = InputReader.getCode(scanner, Constants.maxCodeOfBrand);

            System.out.println(Constants.modelInput);

            String model = InputReader.getModel(scanner);

            System.out.println(Constants.typeInput);

            TypeOfDeviceEnum.printTypes();

            int codeOfType = InputReader.getCode(scanner, Constants.maxCodeOfType);

            System.out.println(Constants.colorInput);

            ColorOfDeviceEnum.printColors();

            int codeOfColor = InputReader.getCode(scanner, Constants.maxCodeOfColor);

            System.out.println(Constants.releaseDateInput);

            Date releaseDate = InputReader.getDate(scanner);

            deviceAdditionController.addDevice(codeOfBrand, model, codeOfType, codeOfColor, releaseDate);

            System.out.println(Constants.deviceAdditionSuccess);
        } catch (GoToMenuException e) {
            MainMenu.showMenu();
        } catch (ExitException e) {
            MainMenu.setActive(false);
        }
    }
}
