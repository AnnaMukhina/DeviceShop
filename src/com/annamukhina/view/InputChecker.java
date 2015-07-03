package com.annamukhina.view;

import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;
import com.annamukhina.view.exceptions.StringInputException;
import com.annamukhina.view.exceptions.WrongCodeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author anna_mukhina
 *
 * Contains methods for user input check.
 */
public class InputChecker {
    private static final Pattern stringPattern = Pattern.compile("[A-Za-zA-Яа-я' -]+");
    private static final Pattern modelPattern = Pattern.compile("\\w+");
    private static final Pattern yearPattern = Pattern.compile("[0-9]{4}");
    private static final String EXIT = "exit";
    private static final String MENU = "menu";

    /**
     * Checks does user date input contain command or not.
     * If it does throws exception for the command execution.
     *
     * @param input user input string
     * @throws GoToMenuException if user input equals "menu" command
     * @throws ExitException if user input equals "exit" command
     */
    public static void checkDate(String input) throws GoToMenuException, ExitException {
        switch (input) {
            case EXIT:
                throw new ExitException();
            case MENU:
                throw new GoToMenuException();
        }
    }

    /**
     * Checks is user text string input correct and does it contain command or not.
     * If it isn't correct throws exception.
     * If it contains command throws exception for the command execution.
     *
     * @param input user input text string
     * @throws StringInputException if user input text string isn't correct (contains digits, symbols)
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
    public static void checkString(String input) throws StringInputException, ExitException, GoToMenuException {
        Matcher matcher = stringPattern.matcher(input);
        boolean matches = matcher.matches();
        if (!matches) {
            throw new StringInputException();
        }
        if(input.equals(EXIT)) {
            throw new ExitException();
        }
        else if(input.equals(MENU)) {
            throw new GoToMenuException();
        }
    }

    /**
     * Checks is user model of the device input correct and does it contain command or not.
     * If it isn't correct throws exception.
     * If it contains command throws exception for the command execution.
     *
     * @param input user model of the device input
     * @throws StringInputException if user input text string isn't correct (contains symbols)
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     */
    public static void checkModel(String input) throws StringInputException, ExitException, GoToMenuException {
        Matcher matcher = modelPattern.matcher(input);
        boolean matches = matcher.matches();
        if (!matches) {
            throw new StringInputException();
        }
        if(input.equals(EXIT)) {
            throw new ExitException();
        }
        else if(input.equals(MENU)) {
            throw new GoToMenuException();
        }
    }

    /**
     * Checks is user number input correct and does it contain command or not.
     * If it isn't correct throws exception.
     * If it contains command throws exception for the command execution.
     *
     * @param input user number input
     * @param maxNumber maximum permitted value for the input number
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     * @throws WrongCodeException if user number input isn't correct
     * (contains symbols, letters, is bigger than maxNumber or is smaller than 0)
     */
    public static void checkNumber(String input, int maxNumber) throws ExitException, GoToMenuException, WrongCodeException {
        switch (input) {
            case EXIT:
                throw new ExitException();
            case MENU:
                throw new GoToMenuException();
            default:
                int code = Integer.parseInt(input);
                int minNumber = 0;
                if (code < minNumber || code > maxNumber) {
                    throw new WrongCodeException();
                }
                break;
        }
    }

    /**
     * Checks is user year input correct and does it contain command or not.
     * If it isn't correct throws exception.
     * If it contains command throws exception for the command execution.
     *
     * @param input user year input
     * @throws ExitException if user input equals "exit" command
     * @throws GoToMenuException if user input equals "menu" command
     * @throws StringInputException if user year input isn't correct
     * (contains more than 4 digits or contains letters, symbols)
     */
    public static void checkYear(String input) throws ExitException, GoToMenuException, StringInputException {
        switch (input) {
            case EXIT:
                throw new ExitException();
            case MENU:
                throw new GoToMenuException();
            default:
                Matcher matcher = yearPattern.matcher(input);
                boolean matches = matcher.matches();
                if (!matches) {
                    throw new StringInputException();
                }
                break;
        }
    }
}
