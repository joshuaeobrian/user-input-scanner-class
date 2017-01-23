package com.theironyard;


import java.util.List;
import java.util.Scanner;

public class MenuService {

    private Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

    public double promptForWeight() {
        System.out.println("Enter a weight: ");

        if(scanner.hasNextDouble()){
           return scanner.nextDouble();
        } else {
            String badInput = scanner.nextLine();

            System.out.printf("%s is not a number\n", badInput);

            return promptForWeight();
        }
    }

    public Weight promptForFromUnit(List<String> units) {
        System.out.printf("Select the unit to convert from %s:\n", units);

        String type = scanner.next();

        if(!units.contains(type)){
            System.out.println("Please choose a valid unit to convert from.");

            return promptForFromUnit(units);
        } else {
            return Weight.valueOf(type.toUpperCase());
        }
    }

    public Weight promptForToUnit(List<String> units) {
        System.out.printf("Select the unit to convert to %s:\n", units);

        String type = scanner.next();

        if(!units.contains(type)){
            System.out.println("Please choose a valid unit to convert to.");

            return promptForToUnit(units);
        } else {
            return Weight.valueOf(type.toUpperCase());
        }
    }

    public void printAnswer(double number, Weight from, double converted, Weight to) {
        System.out.printf("%s %ss is %s %ss", number, from.toString().toLowerCase(), converted, to.toString().toLowerCase());

    }
}
