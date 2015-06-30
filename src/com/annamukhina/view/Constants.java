package com.annamukhina.view;

import com.annamukhina.model.enums.BrandOfDeviceEnum;
import com.annamukhina.model.enums.ColorOfDeviceEnum;
import com.annamukhina.model.enums.TypeOfDeviceEnum;

import java.text.SimpleDateFormat;

/**
 * @author anna_mukhina
 */
public class Constants {
    public static final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public static final String surnameInput = "Фамилия:";

    public static final String nameInput = "Имя:";

    public static final String middleNameInput = "Отчество:";

    public static final String dateInput = "Дата рождения в формате 01.01.2015:";

    public static final String clientAdditionSuccess = "Клиент успешно внесен в систему.";

    public static int maxCodeOfBrand = BrandOfDeviceEnum.Brands.values().length - 1;

    public static int maxCodeOfType = TypeOfDeviceEnum.Types.values().length - 1;

    public static int maxCodeOfColor = ColorOfDeviceEnum.Colors.values().length - 1;

    public static String brandInput = "Введите номер марки из списка, приведенного ниже:";

    public static String modelInput = "Введите модель устройства, например, iPhone6:";

    public static String typeInput = "Введите номер типа устройства из списка, приведенного ниже:";

    public static String colorInput = "Введите номер цвета из списка, приведенного ниже:";

    public static String releaseDateInput = "Введите дату выпуска устройства в формате 01.01.2015:";

    public static String deviceAdditionSuccess = "Девайс успешно внесен в систему.";

    public static String clientIdInput = "ID клиента:";

    public static String orderInput = "Позиции чека (id количество):";

    public static String saleAdditionSuccess = "Информация о продаже внесена в систему.";

    public static String deviceIdInput = "Введите id девайса:";

    public static final String wrongDateWarning = "Пожалуйста, введите дату корректно.";

    public static final String wrongInputWarning = "Некорректный ввод. Попробуйте снова.";

    public static final String deviceReleaseYearInput = "Введите год выпуска девайса:";

    public static final String fail = "Неверный ввод команды, попробуйте снова.";

    public static final int maxClientID = 1000000000;

    public static int maxDeviceID = 1000000000;
}
