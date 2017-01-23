package com.theironyard;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.doughughes.testifier.exception.CannotAccessMethodException;
import net.doughughes.testifier.exception.CannotFindEnumException;
import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.exception.CannotInvokeMethodException;
import net.doughughes.testifier.test.TestifierTest;
import net.doughughes.testifier.util.Invoker;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by doug on 1/19/17.
 */
@RunWith(JUnitParamsRunner.class)
public class WeightTest extends TestifierTest {

    @Test
    @Parameters
    public void testEnumValues(String weight, double value) {
        /* arrange */
        Weight unit = null;
        try {
            unit = (Weight) Invoker.getEnumValue(Weight.class, weight);
        } catch (CannotFindEnumException e) {
            fail(e.getMessage());
        }

        double grams = -1;
        try {
            Weight enumValue = (Weight) Invoker.getEnumValue(Weight.class, "GRAM");
            grams = (double) Invoker.invoke(enumValue, "getGrams");
        } catch (CannotInvokeMethodException | CannotFindMethodException | CannotAccessMethodException | CannotFindEnumException e) {
            fail(e.getMessage());
        }

        /* act */

        /* assert */
        assertThat(weight + " should be " + value + " grams",
                grams, closeTo(value, 0.0001));
    }

    private Object[] parametersForTestEnumValues() throws CannotFindEnumException {
        return new Object[]{
                new Object[]{"TON", 907184.74},
                new Object[]{"POUND", 453.59237},
                new Object[]{"OUNCE", 28.349523},
                new Object[]{"STONE", 6350.2932},
                new Object[]{"METRIC_TON", 1000000},
                new Object[]{"KILOGRAM", 1000},
                new Object[]{"GRAM", 1}
        };
    }

}