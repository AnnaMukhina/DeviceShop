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
 *
 * Contains methods for user input reading.
 */
public class InputReader {
    /**
     * Reads user text string input. Calls method for the text validation.
     * Returns input string if it's correct or "error" if it isn't.
     *
     * @param scanner scanner of the System.in stream
     * @return input string or "error"
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
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

    /**
     * Reads user date input. Calls method for the date validation.
     * Returns input date if it's correct or null if it isn't.
     *
     * @param scanner scanner of the System.in stream
     * @return input date or null
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
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

    /**
     * Reads user model of the device input. Calls method for the model validation.
     * Returns input model if it's correct or "error" if it isn't.
     *
     * @param scanner scanner of the System.in stream
     * @return input model or "error"
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
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

    /**
     * Reads user number input. Calls method for the number validation.
     * Returns input number if it's correct or -1 if it isn't.
     *
     * @param scanner scanner of the System.in stream
     * @param maxNumber maximum permitted value for the input number
     * @return input number or -1
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
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

    /**
     * Reads user year input. Calls method for the year validation.
     * Returns input year if it's correct or -1 if it isn't.
     *
     * @param scanner scanner of the System.in stream
     * @return input year or -1
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
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

    /**
     * Recursively calls method for user input reading and check until input is correct.
     * Returns correct input number.
     *
     * @param scanner scanner of the System.in stream
     * @param maxNumber maximum permitted value for the input number
     * @return correct input number
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
    public static int getCode(Scanner scanner, int maxNumber) throws ExitException, GoToMenuException {
        int code = readNumber(scanner, maxNumber);

        while(code == -1) {
            code = readNumber(scanner, maxNumber);
        }
        return code;
    }

    /**
     * Recursively calls method for user input reading and check until input is correct.
     * Returns correct input date.
     *
     * @param scanner scanner of the System.in stream
     * @return correct input date
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
    public static Date getDate(Scanner scanner) throws ExitException, GoToMenuException {
        Date date = readDate(scanner);

        while(date == null) {
            date = readDate(scanner);
        }
        return date;
    }

    /**
     * Recursively calls method for user input reading and check until input is correct.
     * Returns correct input model of the device.
     *
     * @param scanner scanner of the System.in stream
     * @return correct input model of the device
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
    public static String getModel(Scanner scanner) throws ExitException, GoToMenuException {
        String input = readModel(scanner);

        while(input.equals("error")) {
            input = readModel(scanner);
        }
        return input;
    }

    /**
     * Recursively calls method for user input reading and check until input is correct.
     * Returns correct input string.
     *
     * @param scanner scanner of the System.in stream
     * @return correct input string
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
    public static String getString(Scanner scanner) throws ExitException, GoToMenuException {
        String input = readString(scanner);

        while(input.equals("error")) {
            input = readString(scanner);
        }
        return input;
    }

    /**
     * Recursively calls method for user input reading and check until input is correct.
     * Returns correct input year.
     *
     * @param scanner scanner of the System.in stream
     * @return correct input year
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
    public  static int getYear(Scanner scanner) throws ExitException, GoToMenuException {
        int input = readYear(scanner);

        while(input == -1) {
            input = readYear(scanner);
        }
        return input;
    }
}
