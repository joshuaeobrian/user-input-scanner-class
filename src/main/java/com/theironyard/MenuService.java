package com.theironyard;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The MenuService class is used to prompt users for data and to collect that
 * input. It is also responsible for validating that input. For example, if we
 * prompt the user for a number, we must reject the value 'Fred' and prompt the
 * user again until they enter a valid number. The MenuService has methods that
 * encapsulate all of this logic. This means that we can invoke, for example,
 * the promptForWeight() method and know that we will get a double back, not a
 * String and not an error.
 *
 * Follow the instructions below to implement each of these methods.
 */
public class MenuService {

    /**
     * Create a private property that holds an instance of Scanner provided to
     * the class by its constructor.
     */
    // todo: create private Scanner property
	private Scanner scanner;
//region:Instructions
    /**
     * Create a constructor that receives an instance of Scanner and sets it
     * into the private Scanner property created above.
     *
     * You may be wondering why we're passing Scanner into this class when we
     * could have simply created a new instance here. This is an example of a
     * pattern called Dependency Injection. This MenuService class depends on
     * the Scanner class and can't work without it. However, if it knows how to
     * create an instance of Scanner it also has to know some details about
     * other parts of the system that may be irrelevant. For example, System.in.
     *
     * Also, by passing in the Scanner when the MenuService is instantiated, we
     * have the option to pass in other types of Scanners that are configured in
     * different ways. For example, all of the tests written for the MenuService
     * have Scanner configured with a different InputStream than stdin. That
     * allows our tests to automate input and confirm that the results are what
     * we expect.
     *
     * @param scanner An instance of Scanner.
     */
    //endregion
    // todo: create MenuService constructor
	public MenuService(Scanner scanner) {
		this.scanner = scanner;
	}
//region:Instructions
	/**
     * Create a method named promptForWeight(). It should accept no arguments
     * and return a double value. The double value is, of course, the value the
     * user inputs on the command line.
     *
     * This method must take into account that users are finicky beasts that may
     * not follow instructions. Users might enter values that are not numbers.
     *
     * Follow the instructions in the following comments to complete this method
     * correctly.
     *
     * @return a double value which is a weight.
     */
	//endregion
    // todo: create a method named promptForWidget() that returns a double
		public double promptForWeight() {
			double response;
//region:Notes
        /*
            We need to prompt the user to input a weight. We can do this by
            writing out to the console using System.out.println(). As a side
            note System.out.println() writes to stdout, or Standard Output.

            You should prompt the user with the text "Enter a weight: ".

            Be sure to use println() or explicitly add a \n character as a line
            break after the prompt. This is only required because the tests for
            this class expect it.

            Also note, there is nothing special about println() here. We're only
            calling it a prompt because it's telling the user what to do.
            Without it, the user wouldn't know to enter a weight.
         */
        //endregion
			while(true) {
				// todo: prompt the user with "Enter a weight: "
				System.out.println("Enter a weight: ");
//region:Notes
        /*
            Now we need to see if the user inputs a numeric value. We can check
            this by calling the Scanner class' hasNextDouble() method. This
            method returns true if there is a double value we can read, false if
            there is something other than a double value to read, and will
            otherwise pause the program and wait until it receives input before
            returning true or false.

            The result from calling hasNextDouble() can be used in a conditional
            statement. This allows us to write logic like, "If the user provided
            a valid double, return it. Otherwise, chastise the user for
            providing bad input and try again."

            In other words, you need to write an if block that checks if the
            user's input is a double.
         */
				//endregion
				// todo: write if statement that checks if the user input a double
				if (scanner.hasNextDouble()) {
//region:Notes

            /*
                If hasNextDouble() has returned true then the user has entered a
                valid double value. But, we haven't yet read it. We need to do
                so and return that value. We can read the double the user input
                by invoking the Scanner class' nextDouble() method.
             */
					//endregion
					// todo: return the double the user entered
					response = scanner.nextDouble();
					return response;
				}
				// todo: write else statement
				else {
//region:Notes
            /*
                If hasNextDouble() has returned false then the user entered
                something that was not a double value. It's important to note
                that the hasXyz() methods on Scanner do not actually read the
                value, they just indicate if the value is or is not something.
                So, even though we called hasNextDouble(), we must read the bad
                value to move beyond it.

                We must read the bad value by using the nextLine() method of
                Scanner. Since we're reading it, we may as well hold on to the
                value and print that as a part of an error message.
             */
					// todo: read the bad input and store it in a variable
					String input = scanner.nextLine();

            /*
                We know we've received bad input from the user and we've read it
                using nextLine(). We need to try to prompt the user again so
                they can provide a valid number. However, we might confuse the
                user if we just show a new prompt without explaining that their
                original input was invalid. So, let's show an error message that
                tells them what went wrong. It should read: "XYZ is not a
                number", where XYZ is replaced with the value the user input.

                For example, if the user input 'test 123' then the error message
                would read: "test 123 is not a number"

                This message must be followed by a single line break so either
                use println() or explicitly end the string with a '\n'.
             */
					//endregion
					// todo: print error message reading "XYZ is not a number" followed by a single linebreak
					System.out.println(input + " is not a number");
					//region
				/*
                Now that we've told our users what's wrong with their input. We
                need to prompt them to try again. It's possible to do this by
                using a loop that iterates, prompting the user for a weight
                until the user provides valid input. Something like:

                // assume data is invalid
                while(dataIsInvalid){
                    // prompt for data

                    // check if data is invalid

                    // if data is invalid...

                    //print error
                }

                // return valid data

                But, we already have a nice, clean method that can prompt a user
                for a weight and validate the data: promptForWeight()! Why don't
                we just return the result from calling promptForWeight()?

                If that didn't make sense, reread it a few times. If it still
                doesn't make sense, that's quite ok. It's a confusing idea, so
                let's explore it.

                First off, methods can call themselves. This is called
                recursion and is a very important topic. It is also unintuitive.
                Here's a scenario:

                - invoke promptForWeight()
                    - prompt user for data
                    - user provides bad data
                    - output error message
                        - invoke promptForWeight()
                            - prompt user for data
                            - user provides bad data
                            - output error message
                                - invoke promptForWeight()
                                    - user provides good data
                                    - return good data
                            - return good data
                    - return good data

                Don't think too hard about it right now. All you need to know is
                that if you return the result of calling this method -
                promptForWeight() - again, your users will be repeatedly
                prompted for a weight until they provide a valid value.
             */
					//endregion
					// todo: return the results from calling promptForWeight()

				}
			}
		}
//region:Instructions
    /**
     * Create a method called promptForFromUnit(). This method accepts an
     * ArrayList of String units and returns a valid Weight enum value that the
     * user selects.
     *
     * This method's name leaves something to be desired, but is intended to
     * prompt the user for the unit they want to convert their weight value
     * from. These values are provided by the argument, shown in the prompt, and
     * are also used to validate that the user provided a valid data.
     *
     * Follow the instructions below to build out this method.
     *
     * @param units An ArrayList of String values that are valid units
     * @return A Weight enum value corresponding to the user's selected unit
     */
    //endregion
    // todo: implement promptForFromUnit() method
	public Weight promptForFromUnit(ArrayList<String> units) {//region
		   /*
            We need to prompt the user for the unit they are converting from.
            For example, if the list provided is ["gram", "pound", "stone"],
            then the prompt displayed will be:

            "Select the unit to convert from [gram, pound, stone]: "

            Note that the toString() method of a List will convert it to the
            form shown above. EG: [gram, pound, stone]. So, you should be able
            to simply write a String expression similar to:

            `"Select the unit to convert from " + units + ": "`

            Don't forget the trailing colon!

            The prompt must be followed by a single newline character. This can
            be automatically added via println() or manually added using '\n'
            with a different print function.
         */

        //endregion
		// todo: prompt the user for the unit to convert from
		Weight weight = promptSelection("from",units);
		return weight;
	}
//region
        /*
            We can safely assume that any value the user provides will be a
            String. As such, we can use the Scanner class' next() method to read
            and return the value. The next() method always returns the next
            token from Scanner up to the next delimiter instance. We set this to
            be a new line (\n) character in Main class, so it should read the
            entire remaining line of text. If there is no input Scanner will
            pause the application until the user provides input.

            You should save this data into variable.
         */
			//endregion
			// todo: read the next line of input using the next() method and save it in a variable
//region :notes
        /*
            Now we need to validate the input the user provided is valid.
            Remember that the value must be one of those in the list that was
            provided as an argument to this method. For example, if the list was
            ["gram", "pound", "stone"], the user must have typed gram, stone, or
            pound. If they type "Fred" then that is an error.

            We can check to see if the provided input is valid by invoking the
            list's contains() method. The contains() method accepts an single
            argument and checks to see if the list contains that value. It
            returns true or false accordingly.

            As such, we can write a conditional expression that effectively
            says, "If the user did not provide a valid unit, then chastise them
            and prompt them to try again. If they did provide a valid unit then
            return it."

            In other words, you need to write an if block that checks if the
            user's input is not a valid unit.
         */
			//endregion
			// todo: write if statement that checks if the user's input is not a valid unit
///region

	// prints out formatted selection statement saves on repetition



            /*
                If the user's input is not a valid unit them we need to print a
                an error message. The message should read:

                "Please choose a valid unit to convert from."

                It must be followed by a single line break character.
             */
		// todo: print error message reading "Please choose a valid unit to convert from." followed by a single linebreak


            /*
                As with the promptForWeight() method above, we can recursively
                invoke this method until the user inputs a valid value. In other
                words, we simply need to return the results of invoking
                promptForFromUnit() again. Be sure to pass in the list of units
                we received when we re-invoke promptForFromUnit().
             */
		// todo: return the result of calling promptForFromUnit() again


		// todo: write else statement

            /*
                If the user's input was valid we need to convert it to a valid
                Weight enum value and return it. All enums provide a method
                valueOf() that converts a string to the correct enum value. For
                example: Weight.valueOf("POUND") returns Weight.POUND.

                Don't forget that the users will have typed a lowercase string
                for the unit. As such, you'll need to convert the string to be
                all uppercase. The String method provides a toUpperCase() method
                that does this. Also, if the user typed "metric ton" you will
                need to replace the space with an underscore. You can do this
                using the String class' replaceAll() method.
             */
		// todo: return the Weight enum value corresponding to the unit the user typed in

    /**
     * Create a method named promptForToUnit(). This method works exactly the
     * same as the promptForFromUnit() method, except that its prompts read:
     *
     * "Select the unit to convert from [gram, pound, stone]: "
     *
     * In the example above, the units listed are driven based on the provided
     * ArrayList of Strings.
     *
     * If the user makes an invalid selection the error message reads:
     *
     * "Please choose a valid unit to convert to."
     *
     * Other than that, this method is the same as promptForFromUnit().
     *
     * @param units A List of String values that are valid units
     * @return A Weight enum value corresponding to the user's selected unit
     */
//endregion
    // todo: implement promptForToUnit() method
	public Weight promptForToUnit(ArrayList<String> units){
		Weight weight = promptSelection("to",units);
		return weight;
	}

//region:Instructions
    /**
     * Create a method named printAnswer(). It should accept arguments for the
     * weight to convert, the unit being converted from, the unit being
     * converted to, and the converted value. It returns nothing.
     *
     * When invoked, this method prints a message like this:
     *
     * "ABC in Xs is XYZ in Qs"
     *
     * Where ABC is the weight being converted, X is the unit being converted
     * from, XYZ is the converted value, and Q is the unit converted to. Here's
     * a real example:
     *
     * "321.0 pounds is 145603.15077 grams"
     *
     * Pay attention to plurals, but don't worry about singulars. In other
     * words, it's ok to always write pounds, even "1 pounds".
     *
     * The output must be followed by a single newline character.
     *
     * @param number The weight being converted
     * @param from The unit being converted from
     * @param converted The converted value
     * @param to The unit of the converted value
     */
    //endregion
    // todo: implement printAnswer() method
	public void printAnswer(double number,Weight from, double converted, Weight to ){

		System.out.printf("%s %ss is %s %ss",number,from.toString().toLowerCase(),converted,to.toString().toLowerCase());
	}

	//handles while look and Statement
	private Weight promptSelection(String toOrFrom, ArrayList<String> units){
		String input;
		while(true){
			//printing from return of private method that makes the output in proper format
			System.out.println(printString("Select the unit to convert "+toOrFrom+" [",units));

			input = scanner.next();

			if(units.contains(input)) {
				//calls private method that return Weight
				return checkArrayForMatch(input, units);
			}
			System.out.println("Please choose a valid unit to convert "+toOrFrom+".");
		}
	}

//printing from return of private function that makes the output in proper format
	private String printString(String startingString,ArrayList<String>units){

		for(int index = 0; index < units.size(); index++){
			if((units.size()-1) ==index){
				startingString+= units.get(index)+"]: ";
			}else{
				startingString+= units.get(index)+", ";
			}
		}
		return startingString;
	}


	//private method that return Weight saves on repetition
	private Weight checkArrayForMatch(String input,ArrayList<String> units){
		for (int i = 0; i < units.size(); i++) {
			if (input.equals(units.get(i))) {
				if (units.get(i).contains("_")) {
					input = units.get(i).replace(" ", "_");
				}
				input = input.toUpperCase();
			}
		}
		return Weight.valueOf(input);
	}


}
