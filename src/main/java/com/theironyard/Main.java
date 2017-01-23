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

        ConversionService converter = new ConversionService();
        MenuService menu = new MenuService(scanner);

        // prompt for a weight to convert
        double number = menu.promptForWeight();

        // prompt for the from unit
        Weight from = menu.promptForFromUnit(converter.listUnits());

        // prompt for the to unit
        Weight to = menu.promptForToUnit(converter.listUnits());

        // convert the weight
        double converted = converter.convert(number, from, to);

        // print the answer
        menu.printAnswer(number, from, converted, to);

    }

}
