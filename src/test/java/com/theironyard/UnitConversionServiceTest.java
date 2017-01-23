package com.theironyard;

import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.test.TestifierTest;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by doug on 1/19/17.
 */
public class UnitConversionServiceTest extends TestifierTest {

    @Test
    public void testConvert25InchesToMillimeters() {
        /* arrange */
        UnitConversionService service = new UnitConversionService();

        /* act */
        double result = service.convert(25, Length.INCH, Length.MILLIMETER);

        /* assert */
        assertThat("25 inches should be 635 mm",
                result, closeTo(635, 0.0001));
    }

    @Test
    public void testConvert25MillimetersToInches() {
        /* arrange */
        UnitConversionService service = new UnitConversionService();

        /* act */
        double result = service.convert(25, Length.MILLIMETER, Length.INCH);

        /* assert */
        assertThat("25 mm should be 0.98425197 in",
                result, closeTo(0.98425197, 0.0001));
    }

    @Test
    public void testConvert1StoneToPounds() {
        /* arrange */
        UnitConversionService service = new UnitConversionService();

        /* act */
        double result = service.convert(1, Weight.STONE, Weight.POUND);

        /* assert */
        assertThat("1 stone should be 14 pounds",
                result, closeTo(14, 0.0001));
    }

    @Test
    public void testConvert200PoundsToKilograms() {
        /* arrange */
        UnitConversionService service = new UnitConversionService();

        /* act */
        double result = service.convert(200, Weight.POUND, Weight.KILOGRAM);

        /* assert */
        assertThat("200 pounds should be 90.718474 kilograms",
                result, closeTo(90.718474, 0.0001));
    }

    @Test
    public void testListLengths(){
        /* arrange */
        UnitConversionService service = new UnitConversionService();

        /* act */
        List<String> result = service.listLengthUnits();

        /* assert */
        assertThat("Length units should include all of the following: mile, yard, foot, inch, kilometer, meter, centimeter, and millimeter",
                result, containsInAnyOrder("mile", "yard", "foot", "inch", "kilometer", "meter", "centimeter", "millimeter"));

    }

    @Test
    public void testListWeights(){
        /* arrange */
        UnitConversionService service = new UnitConversionService();

        /* act */
        List<String> result = service.listWeightUnits();

        /* assert */
        assertThat("Weight units should include all of the following: mile, yard, foot, inch, kilometer, meter, centimeter, and millimeter",
                result, containsInAnyOrder("ton", "pound", "ounce", "stone", "metric ton", "kilogram", "gram"));
    }

    @Test
    public void testListLengthUnitsUsesValuesMethod(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("listLengthUnits");
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("listLengthUnits() method should use the values() method of the Length enum",
                source, RegexMatcher.matches("^.*?MethodCallExpr NameExpr\\[Length\\] MethodName\\[values\\] MethodArguments /MethodArguments /MethodCallExpr.*?$"));
    }

    @Test
    public void testListWeightUnitsUsesValuesMethod(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("listWeightUnits");
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("listWeightUnits() method should use the values() method of the Weight enum",
                source, RegexMatcher.matches("^.*?MethodCallExpr NameExpr\\[Weight\\] MethodName\\[values\\] MethodArguments /MethodArguments /MethodCallExpr.*?$"));
    }

    @Test
    public void testListConversionTypes(){
        /* arrange */
        UnitConversionService service = new UnitConversionService();

        /* act */
        List<String> result = service.listConversionTypes();

        /* assert */
        assertThat("Conversion types should include: length, distance",
                result, containsInAnyOrder("length", "distance"));
    }
}