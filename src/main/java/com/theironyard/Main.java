package com.theironyard;

import java.util.Scanner;

/**
 * Hello world!
 */
public class Main {

    public static void main(String[] args) {
        // setup objects
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        UnitConversionService converter = new UnitConversionService();
        MenuService menu = new MenuService(scanner);

        // prompt for conversion type
        String type = menu.selectConversionType(converter.listConversionTypes());

        // prompt for the number to convert
        double number = menu.promptForNumber(type);

        // prompt for the from and to units
        if(type.equals("length")) {
            menu.promptForFromUnit(converter.listLengthUnits());
            menu.promptForToUnit(converter.listLengthUnits());
        } else {

        }

    }

}
