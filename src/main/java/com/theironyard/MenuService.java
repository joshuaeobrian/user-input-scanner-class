package com.theironyard;


import java.util.List;
import java.util.Scanner;

public class MenuService {

    private Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectConversionType(List<String> conversionTypes) {
        System.out.printf("Select conversion type %s:\n", conversionTypes);

        String type = scanner.next();

        if(!conversionTypes.contains(type)){
            System.out.println("Please choose a valid conversion type.");

            return selectConversionType(conversionTypes);
        } else {
            return type;
        }
    }

    public double promptForNumber(String type) {
        System.out.println("Enter a " + type);

        if(scanner.hasNext() && scanner.hasNextDouble()){
           return scanner.nextDouble();
        } else {
            String badInput = scanner.nextLine();

            System.out.printf("%s is not a number\n", badInput);

            return promptForNumber(type);
        }
    }

    public String promptForFromUnit(List<String> units) {
        System.out.printf("Select the unit to convert from %s:\n", units);

        String type = scanner.next();

        if(!units.contains(type)){
            System.out.println("Please choose a valid unit to convert from.");

            return selectConversionType(units);
        } else {
            return type;
        }
    }

    public String promptForToUnit(List<String> units) {
        System.out.printf("Select the unit to convert to %s:\n", units);

        String type = scanner.next();

        if(!units.contains(type)){
            System.out.println("Please choose a valid unit to convert to.");

            return selectConversionType(units);
        } else {
            return type;
        }
    }
}
