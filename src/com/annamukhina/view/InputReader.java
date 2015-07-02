package com.annamukhina.view;

import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;
import com.annamukhina.view.exceptions.StringInputException;
import com.annamukhina.view.exceptions.WrongCodeException;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author anna_mukhina
 */
public class InputReader {
    public static String readString(Scanner scanner) throws ExitException, GoToMenuException {
        String input = scanner.next();
        try {
            InputChecker.checkString(input);

            return input;
        } catch (StringInputException sie) {
            System.out.println(Constants.wrongInputWarning);

            return "error";
        }
    }

    public static Date readDate(Scanner scanner) throws ExitException, GoToMenuException {
        String input = scanner.next();
        try {
            InputChecker.checkDate(input);

            return Constants.FORMAT.parse(input);
        } catch (ParseException e) {
            System.out.println(Constants.wrongDateWarning);

            return null;
        }
    }

    public static String readModel(Scanner scanner) throws ExitException, GoToMenuException {
        String input = scanner.next();
        try {
            InputChecker.checkModel(input);

            return input;
        } catch (StringInputException sie) {
            System.out.println(Constants.wrongInputWarning);

            return "error";
        }
    }

    public static int readNumber(Scanner scanner, int maxNumber) throws ExitException, GoToMenuException {
        String input = scanner.next();
        try {
            InputChecker.checkNumber(input, maxNumber);

            return Integer.parseInt(input);
        } catch (WrongCodeException e) {
            System.out.println(Constants.wrongInputWarning);

            return -1;
        } catch (NumberFormatException e) {
            System.out.println(Constants.wrongInputWarning);

            return -1;
        }
    }

    public static int readYear(Scanner scanner) throws ExitException, GoToMenuException {
        String input = scanner.next();
        try {
            InputChecker.checkYear(input);

            return Integer.parseInt(input);
        } catch (StringInputException sie) {
            System.out.println(Constants.wrongInputWarning);

            return -1;
        }
    }

    public static int getCode(Scanner scanner, int maxNumber) throws ExitException, GoToMenuException {
        int code = readNumber(scanner, maxNumber);

        while(code == -1) {
            code = readNumber(scanner, maxNumber);
        }
        return code;
    }

    public static Date getDate(Scanner scanner) throws ExitException, GoToMenuException {
        Date date = readDate(scanner);

        while(date == null) {
            date = readDate(scanner);
        }
        return date;
    }

    public static String getModel(Scanner scanner) throws ExitException, GoToMenuException {
        String input = readModel(scanner);

        while(input.equals("error")) {
            input = readModel(scanner);
        }
        return input;
    }

    public static String getString(Scanner scanner) throws ExitException, GoToMenuException {
        String input = readString(scanner);

        while(input.equals("error")) {
            input = readString(scanner);
        }
        return input;
    }

    public  static int getYear(Scanner scanner) throws ExitException, GoToMenuException {
        int input = readYear(scanner);

        while(input == -1) {
            input = readYear(scanner);
        }
        return input;
    }
}
