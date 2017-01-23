package com.theironyard;

import net.doughughes.testifier.exception.*;
import net.doughughes.testifier.test.TestifierTest;
import net.doughughes.testifier.util.Invoker;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MenuServiceTest extends TestifierTest {

    @Test
    public void testPromptForWeightWith123Point456() {
        /* arrange */
        ByteArrayInputStream is = new ByteArrayInputStream("123.456\n".getBytes());
        Scanner scanner = new Scanner(is);
        MenuService menuService = null;
        try {
            menuService = (MenuService) Invoker.instantiate(MenuService.class, scanner);
        } catch (CannotFindConstructorException | CannotInstantiateClassException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }

        /* act */
        double weight = 0;
        try {
            weight = (double) Invoker.invoke(menuService, "promptForWeight");
        } catch (CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }
        List<String> lines = outputWatcher.getLines();

        /* assert */
        assertThat("promptForWeight should have prompted for weight",
                lines.get(0).trim(), equalTo("Enter a weight:"));
        assertThat(weight, closeTo(123.456, 0.0001));
    }

    @Test
    public void testPromptForWeightWithNonnumericThenNumericInput() {
        /* arrange */
        ByteArrayInputStream is = new ByteArrayInputStream("123 test\n321\n".getBytes());
        Scanner scanner = new Scanner(is);
        scanner.useDelimiter("\n");
        MenuService menuService = null;
        try {
            menuService = (MenuService) Invoker.instantiate(MenuService.class, scanner);
        } catch (CannotFindConstructorException | CannotInstantiateClassException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }

        /* act */
        double weight = 0;
        try {
            weight = (double) Invoker.invoke(menuService, "promptForWeight");
        } catch (CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            e.printStackTrace();
        }
        List<String> lines = outputWatcher.getLines();

        /* assert */
        assertThat("promptForWeight should have prompted for weight",
                lines.get(0).trim(), equalTo("Enter a weight:"));
        assertThat("promptForWeight should have output error indicating '123 test' is not a valid number",
                lines.get(1).trim(), equalTo("123 test is not a number"));
        assertThat("promptForWeight should have prompted for weight a second time",
                lines.get(2).trim(), equalTo("Enter a weight:"));
        assertThat("valid input of 321 should have been returned as 321",
                weight, closeTo(321, 0.0001));
    }

    @Test
    public void testPromptForFromUnit(){
        /* arrange */
        ByteArrayInputStream is = new ByteArrayInputStream("pound\n".getBytes());
        Scanner scanner = new Scanner(is);
        scanner.useDelimiter("\n");
        MenuService menuService = null;
        try {
            menuService = (MenuService) Invoker.instantiate(MenuService.class, scanner);
        } catch (CannotFindConstructorException | CannotInstantiateClassException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
        ArrayList<String> units = new ArrayList<>();
        units.add("gram");
        units.add("pound");

        Weight enumValue = null;
        try {
            enumValue = (Weight) Invoker.getEnumValue(Weight.class, "POUND");
        } catch (CannotFindEnumException e) {
            fail(e.getMessage());
        }

        /* act */
        Weight unit = null;
        try {
            unit = (Weight) Invoker.invoke(menuService, "promptForFromUnit", units);
        } catch (CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }
        List<String> lines = outputWatcher.getLines();

        /* assert */
        assertThat("promptForFromUnit should have prompted for a unit using the provided list of units",
                lines.get(0).trim(), equalTo("Select the unit to convert from " + units + ":"));
        assertThat("unit returned should be pound",
                unit.toString(), equalTo(enumValue.toString()));
    }

    @Test
    public void testPromptForFromUnitBadThenGood(){
        /* arrange */
        ByteArrayInputStream is = new ByteArrayInputStream("fred\ngram\n".getBytes());
        Scanner scanner = new Scanner(is);
        scanner.useDelimiter("\n");
        MenuService menuService = null;
        try {
            menuService = (MenuService) Invoker.instantiate(MenuService.class, scanner);
        } catch (CannotFindConstructorException | CannotInstantiateClassException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
        ArrayList<String> units = new ArrayList<>();
        units.add("gram");
        units.add("pound");

        Weight enumValue = null;
        try {
            enumValue = (Weight) Invoker.getEnumValue(Weight.class, "GRAM");
        } catch (CannotFindEnumException e) {
            fail(e.getMessage());
        }

        /* act */
        Weight unit = null;
        try {
            unit = (Weight) Invoker.invoke(menuService, "promptForFromUnit", units);
        } catch (CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }
        List<String> lines = outputWatcher.getLines();

        /* assert */
        assertThat("promptForFromUnit should have prompted for a unit using the provided list of units",
                lines.get(0).trim(), equalTo("Select the unit to convert from " + units + ":"));
        assertThat("promptForFromUnit should have output error indicting an invalid unit",
                lines.get(1).trim(), equalTo("Please choose a valid unit to convert from."));
        assertThat("promptForFromUnit should have re-prompted for a unit after bad input",
                lines.get(2).trim(), equalTo("Select the unit to convert from " + units + ":"));
        assertThat("unit returned should be gram",
                unit.toString(), equalTo(enumValue.toString()));
    }

    @Test
    public void testPromptForToUnit(){
        /* arrange */
        ByteArrayInputStream is = new ByteArrayInputStream("pound\n".getBytes());
        Scanner scanner = new Scanner(is);
        scanner.useDelimiter("\n");
        MenuService menuService = null;
        try {
            menuService = (MenuService) Invoker.instantiate(MenuService.class, scanner);
        } catch (CannotFindConstructorException | CannotInstantiateClassException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
        ArrayList<String> units = new ArrayList<>();
        units.add("gram");
        units.add("pound");

        Weight enumValue = null;
        try {
            enumValue = (Weight) Invoker.getEnumValue(Weight.class, "POUND");
        } catch (CannotFindEnumException e) {
            fail(e.getMessage());
        }

        /* act */
        Weight unit = null;
        try {
            unit = (Weight) Invoker.invoke(menuService, "promptForToUnit", units);
        } catch (CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }
        List<String> lines = outputWatcher.getLines();

        /* assert */
        assertThat("promptForToUnit should have prompted for a unit using the provided list of units",
                lines.get(0).trim(), equalTo("Select the unit to convert to " + units + ":"));
        assertThat("unit returned should be pound",
                unit.toString(), equalTo(enumValue.toString()));
    }

    @Test
    public void testPromptForToUnitBadThenGood(){
        /* arrange */
        ByteArrayInputStream is = new ByteArrayInputStream("fred\ngram\n".getBytes());
        Scanner scanner = new Scanner(is);
        scanner.useDelimiter("\n");
        MenuService menuService = null;
        try {
            menuService = (MenuService) Invoker.instantiate(MenuService.class, scanner);
        } catch (CannotFindConstructorException | CannotInstantiateClassException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
        ArrayList<String> units = new ArrayList<>();
        units.add("gram");
        units.add("pound");

        Weight enumValue = null;
        try {
            enumValue = (Weight) Invoker.getEnumValue(Weight.class, "GRAM");
        } catch (CannotFindEnumException e) {
            fail(e.getMessage());
        }

        /* act */
        Weight unit = null;
        try {
            unit = (Weight) Invoker.invoke(menuService, "promptForToUnit", units);
        } catch (CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }
        List<String> lines = outputWatcher.getLines();

        /* assert */
        assertThat("promptForToUnit should have prompted for a unit using the provided list of units",
                lines.get(0).trim(), equalTo("Select the unit to convert to " + units + ":"));
        assertThat("promptForToUnit should have output error indicting an invalid unit",
                lines.get(1).trim(), equalTo("Please choose a valid unit to convert to."));
        assertThat("promptForToUnit should have re-prompted for a unit after bad input",
                lines.get(2).trim(), equalTo("Select the unit to convert to " + units + ":"));
        assertThat("unit returned should be gram",
                unit.toString(), equalTo(enumValue.toString()));
    }

    @Test
    public void testPrintAnswer(){
        /* arrange */
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        MenuService menuService = null;
        try {
            menuService = (MenuService) Invoker.instantiate(MenuService.class, scanner);
        } catch (CannotFindConstructorException | CannotInstantiateClassException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }

        Weight enumGramValue = null;
        Weight enumPoundValue = null;
        try {
            enumGramValue = (Weight) Invoker.getEnumValue(Weight.class, "GRAM");
            enumPoundValue = (Weight) Invoker.getEnumValue(Weight.class, "POUND");
        } catch (CannotFindEnumException e) {
            fail(e.getMessage());
        }

        /* act */
        try {
            Invoker.invoke(menuService, "printAnswer", 123d, enumGramValue, 0.27116858, enumPoundValue);
        } catch (CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }
        List<String> lines = outputWatcher.getLines();

        /* assert */
        assertThat("printAnswer should have printed conversion text for 123 grams to 0.27116858 pounds",
                lines.get(0).trim(), equalTo("123.0 grams is 0.27116858 pounds"));

    }

}