package com.theironyard;

import net.doughughes.testifier.test.TestifierTest;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class MainTest extends TestifierTest{

    @Test
    public void testMain() {
        /* arrange */
        ByteArrayInputStream is = new ByteArrayInputStream("fred\n123 test\n321\nfred\npound\nfred\ngram\n".getBytes());
        System.setIn(is);

        /* act */
        Main.main(null);
        List<String> lines = outputWatcher.getLines();

        /* assert */
        assertThat("application should have prompted for weight",
                lines.get(0).trim(), equalTo("Enter a weight:"));
        assertThat("application should indicated 'fred' is not a number",
                lines.get(1).trim(), equalTo("fred is not a number"));
        assertThat("application should have prompted for weight again",
                lines.get(2).trim(), equalTo("Enter a weight:"));
        assertThat("application should indicated '123 test' is not a number",
                lines.get(3).trim(), equalTo("123 test is not a number"));
        assertThat("application should have prompted for weight a third time",
                lines.get(4).trim(), equalTo("Enter a weight:"));

        assertThat("application should have asked for a unit to convert from",
                lines.get(5).trim(), startsWith("Select the unit to convert from"));
        assertThat("application should have indicated an invalid selection",
                lines.get(6).trim(), equalTo("Please choose a valid unit to convert from."));
        assertThat("application should have asked for a unit to convert from again",
                lines.get(7).trim(), startsWith("Select the unit to convert from"));

        assertThat("application should have asked for a unit to convert to",
                lines.get(8).trim(), startsWith("Select the unit to convert to"));
        assertThat("application should have indicated an invalid selection",
                lines.get(9).trim(), equalTo("Please choose a valid unit to convert to."));
        assertThat("application should have asked for a unit to convert to again",
                lines.get(10).trim(), startsWith("Select the unit to convert to"));

        assertThat("application should have indicated that 321 lbs is 145603.15077 grams",
                lines.get(11).trim(), equalTo("321.0 pounds is 145603.15077 grams"));


    }
}