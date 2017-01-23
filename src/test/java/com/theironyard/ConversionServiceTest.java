package com.theironyard;

import net.doughughes.testifier.exception.CannotAccessMethodException;
import net.doughughes.testifier.exception.CannotFindEnumException;
import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.exception.CannotInvokeMethodException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.test.TestifierTest;
import net.doughughes.testifier.util.Invoker;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by doug on 1/19/17.
 */
public class ConversionServiceTest extends TestifierTest {

    @Test
    public void testConvert1StoneToPounds() {
        /* arrange */
        ConversionService service = new ConversionService();

        /* act */
        double result = 0;
        try {
            result = (double) Invoker.invoke(service, "convert", 1d, Invoker.getEnumValue(Weight.class, "STONE"), Invoker.getEnumValue(Weight.class, "POUND"));
        } catch (CannotFindEnumException | CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            e.printStackTrace();
        }

        /* assert */
        assertThat("1 stone should be 14 pounds",
                result, closeTo(14, 0.0001));
    }

    @Test
    public void testConvert200PoundsToKilograms() {
        /* arrange */
        ConversionService service = new ConversionService();

        /* act */
        double result = 0;
        try {
            result = (double) Invoker.invoke(service, "convert", 200d, Invoker.getEnumValue(Weight.class, "POUND"), Invoker.getEnumValue(Weight.class, "KILOGRAM"));
        } catch (CannotFindEnumException | CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("200 pounds should be 90.718474 kilograms",
                result, closeTo(90.718474, 0.0001));
    }

    @Test
    public void testConvert2345Point67GramsToTons() {
        /* arrange */
        ConversionService service = new ConversionService();

        /* act */
        double result = 0;
        try {
            result = (double) Invoker.invoke(service, "convert", 2345.67d, Invoker.getEnumValue(Weight.class, "GRAM"), Invoker.getEnumValue(Weight.class, "TON"));
        } catch (CannotFindEnumException | CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("2345.67 grams should be 0.0025856586 tons",
                result, closeTo(0.0025856586, 0.0001));
    }

    @Test
    public void testListWeightUnits(){
        /* arrange */
        ConversionService service = new ConversionService();

        /* act */
        List<String> result = null;
        try {
            result = (List<String>) Invoker.invoke(service, "listUnits");
        } catch (CannotFindMethodException | CannotAccessMethodException | CannotInvokeMethodException e) {
            e.printStackTrace();
        }

        /* assert */
        assertThat("Weight units should include all of the following: mile, yard, foot, inch, kilometer, meter, centimeter, and millimeter",
                result, containsInAnyOrder("ton", "pound", "ounce", "stone", "metric ton", "kilogram", "gram"));
    }

    @Test
    public void testListWeightUnitsUsesValuesMethod(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("listUnits");
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("listUnits() method should use the values() method of the Weight enum",
                source, RegexMatcher.matches("^.*?MethodCallExpr NameExpr\\[Weight\\] MethodName\\[values\\] MethodArguments /MethodArguments /MethodCallExpr.*?$"));
    }

}