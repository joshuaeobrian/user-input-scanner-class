package com.theironyard;

import java.util.Scanner;

/**
 * As we move into writing more complex software we will begin to compose our
 * applications using many classes. Each class is dedicated to some purpose. The
 * different classes depend on each other to complete their jobs.
 *
 * This project's purpose is to create a full-fledged command line application
 * that follows good coding practices. In particular, separation of concerns.
 * This means that each of the classes in this project are dedicated to a
 * specific purpose. The different classes may depend on other classes to
 * complete their jobs.
 *
 * In this exercise we have the following classes:
 *
 * Main - The Main class is the entry point to our application. Its job is to
 *  setup all of the other classes and orchestrate their interactions.
 *
 * ConversionService - In programming, a service is an object that specializes
 *  in a related set of tasks. In this case, the ConversionService specializes
 *  in converting values from one unit to another.
 *
 * MenuService - The MenuService specializes in text-based input and output.
 *  For example, we can use the MenuService to prompt a user for a weight and
 *  collect the value they type in.
 *
 * Weight - The Weight enum contains constants for the different weights we can
 *  convert between.
 *
 * Your job is to follow the instructions in the classes above to build out this
 * application. You will want implement classes in this order:
 *
 * 1) Weight
 * 2) ConversionService
 * 3) MenuService
 * 4) Main
 *
 * Open each of these classes and follow the directions therein.
 */

public class Main {

    public static void main(String[] args) {
        /*
            It is assumed that you have already implemented the MenuService and
            ConversionService classes. Now follow the instructions below to
            complete this main() method.
         */

        /*
            Setup objects

            Let's start by setting up the objects we need for our application to
            work. These are Scanner, ConversionService, and MenuService. Store
            each of these in variables with logical names. EG: `menuService` or
            `converter`.
         */

        // todo: Create a new instance of the Scanner class. It should read from System.in.
        Scanner scanner = new Scanner(System.in);


        // todo: Configure the Scanner instance to use a newline (\n) character as its delimiter
        scanner.useDelimiter("\n");


        // todo: Create a new instance of the ConversionService
            ConversionService conversionService = new ConversionService();


        // todo: Create a new instance of the MenuService. Pass the Scanner instance you created earlier into the MenuService's constructor
            MenuService menuService = new MenuService(scanner);


        /*
            Now that we have our objects configured, we can start to use them.
            By following the instructions below you will write code that prompts
            the user for a weight, then a unit to convert from, then a unit to
            convert to. Finally it will print out the converted results.

            Each of the promptXyz() methods below return a value. You'll want to
            store those in variables that you can then pass to the
            printAnswers() method.
         */

        /*
            Invoke the promptForWeight() method of the MenuService to prompt for
            a weight to convert. This method doesn't accept any arguments, but
            returns a double number that we will be converting.
         */
        // todo: Invoke the MenuService's promptForWeight() method.
            double forWeight = menuService.promptForWeight();


        /*
            Invoke the promptForFromUnit method. This will require you to
            provide a list of valid units to prompt for. This value is provided
            by the ConversionService's listUnits() method. The reason we pass in
            these values is because our MenuService doesn't need to know how to
            get this list. It only needs to know what to print. By having the
            ConversionService specialize in this, our MenuService becomes
            simpler.
         */
        // todo: Invoke the MenuService's promptForFromUnit() method.
           Weight from = menuService.promptForFromUnit(conversionService.listUnits());


        // todo: Invoke the MenuService's promptForToUnit() method.
           Weight to = menuService.promptForToUnit(conversionService.listUnits());



        /*
            Now that we know the weight being converted, the unit we're
            converting from and the unit we're converting to, we can actually
            convert the number. We used the MenuService to collect the
            information, but it's the ConversionService's job to actually
            perform the conversion. This is done by invoking the
            ConversionService's convert() method.
         */
        // todo: Invoke the ConversionService's convert() method.
            double convert = conversionService.convert(forWeight,from,to);


        /*
            At long last we know the weight being converted, the to and from
            units, and the converted value. By passing each of these to the
            MenuService's printAnswer() we can print out the conversion results
            and end the program.
         */
        //todo: Print the answer using the MenuService's printAnswer() method
        menuService.printAnswer(forWeight,from,convert,to);



    }

}
