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
    public static String readString(Scanner scanner) {
        String input = scanner.next();
        try {
            InputChecker.checkString(input);

            return input;
        } catch (StringInputException sie) {
            System.out.println(Constants.wrongInputWarning);
            return "wrong";
        } catch (ExitException ee) {
            System.exit(0);
        } catch (GoToMenuException gtme) {
            MainMenu menu = new MainMenu();
            menu.showMenu();
        }
        return "wrong";
    }

    public static Date readDate(Scanner scanner) {
        String input = scanner.next();
        try {
            InputChecker.checkDate(input);

            return Constants.format.parse(input);
        } catch (ParseException e) {
            System.out.println(Constants.wrongDateWarning);
            return null;
        }
        catch (ExitException ee) {
            System.exit(0);
        } catch (GoToMenuException gtme) {
            //MainMenu.showMenu();
        }
        return null;
    }

    public static String readModel(Scanner scanner) {
        String input = scanner.next();
        try {
            InputChecker.checkModel(input);

            return input;
        } catch (StringInputException sie) {
            System.out.println(Constants.wrongInputWarning);
            return "wrong";
        } catch (ExitException ee) {
            System.exit(0);
        } catch (GoToMenuException gtme) {
           // MainMenu.showMenu();
        }
        return "wrong";
    }

    public static int readNumber(Scanner scanner, int maxNumber) {
        String input = scanner.next();
        try {
            InputChecker.checkNumber(input, maxNumber);

            return Integer.parseInt(input);
        } catch (GoToMenuException e) {
           // MainMenu.showMenu();
        } catch (ExitException e) {
            System.exit(0);
        } catch (WrongCodeException e) {
            System.out.println(Constants.wrongInputWarning);
            return -1;
        } catch (NumberFormatException e) {
            System.out.println(Constants.wrongInputWarning);
        }
        return -1;
    }

    public static int readYear(Scanner scanner) {
        String input = scanner.next();
        try {
            InputChecker.checkYear(input);
            return Integer.parseInt(input);
        } catch (StringInputException sie) {
            System.out.println(Constants.wrongInputWarning);
            return -1;
        } catch (ExitException ee) {
            System.exit(0);
        } catch (GoToMenuException gtme) {
           // MainMenu.showMenu();
        }
        return -1;
    }

    public static int getCode(Scanner scanner, int maxNumber) {
        int code = readNumber(scanner, maxNumber);

        while(code == -1) {
            code = readNumber(scanner, maxNumber);
        }
        return code;
    }

    public static Date getDate(Scanner scanner) {
        Date date = InputReader.readDate(scanner);

        while(date == null) {
            date = InputReader.readDate(scanner);
        }
        return date;
    }

    public static String getModel(Scanner scanner) {
        String input = InputReader.readModel(scanner);

        while(input.equals("wrong")) {
            input = InputReader.readModel(scanner);
        }
        return input;
    }

    public static String getString(Scanner scanner) {
        String input = InputReader.readString(scanner);

        while(input.equals("wrong")) {
            input = InputReader.readModel(scanner);
        }
        return input;
    }

    public  static int getYear(Scanner scanner) {
        int input = InputReader.readYear(scanner);

        while(input == -1) {
            input = InputReader.readYear(scanner);
        }
        return input;
    }
}
