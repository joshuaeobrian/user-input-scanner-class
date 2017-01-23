package com.theironyard;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.doughughes.testifier.test.TestifierTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Created by doug on 1/19/17.
 */
@RunWith(JUnitParamsRunner.class)
public class WeightTest extends TestifierTest {

    @Test
    @Parameters
    public void testEnumValues(Weight weight, double value) throws Exception {
        /* arrange */

        /* act */

        /* assert */
        assertThat(weight + " should be " + value + " grams",
                weight.getGrams(), closeTo(value, 0.0001));
    }


    private Object[] parametersForTestEnumValues() {
        return new Object[]{
                new Object[]{Weight.TON, 907184.74},
                new Object[]{Weight.POUND, 453.59237},
                new Object[]{Weight.OUNCE, 28.349523},
                new Object[]{Weight.STONE, 6350.2932},
                new Object[]{Weight.METRIC_TON, 1000000},
                new Object[]{Weight.KILOGRAM, 1000},
                new Object[]{Weight.GRAM, 1}
        };
    }

}