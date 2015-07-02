package com.annamukhina.view;

import com.annamukhina.view.exceptions.ExitException;
import com.annamukhina.view.exceptions.GoToMenuException;
import com.annamukhina.view.exceptions.StringInputException;
import com.annamukhina.view.exceptions.WrongCodeException;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author anna_mukhina
 */
public class InputChecker {
    private static final Pattern stringPattern = Pattern.compile("[A-Za-zA-Яа-я' -]+");
    private static final Pattern modelPattern = Pattern.compile("\\w+");
    private static final Pattern yearPattern = Pattern.compile("[0-9]{4}");
    private static final String EXIT = "exit";
    private static final String MENU = "menu";

    public static void checkDate(String input) throws GoToMenuException, ExitException, ParseException {
        switch (input) {
            case EXIT:
                throw new ExitException();
            case MENU:
                throw new GoToMenuException();
        }
    }

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
