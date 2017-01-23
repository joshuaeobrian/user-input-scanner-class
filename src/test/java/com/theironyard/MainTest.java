package com.theironyard;

import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.output.OutputStreamInterceptor;
import net.doughughes.testifier.test.TestifierTest;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MainTest extends TestifierTest{

    @Test
    public void testMainOutput() {
        /* arrange */

        /* act */

        /* assert */
        fail("nothing here yet");
        OutputStreamInterceptor out = (OutputStreamInterceptor) System.out;
        assertTrue(true);
    }

    /*@Test
    public void testMainStructure(){
        *//* arrange *//*

        *//* act *//*
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        *//* assert *//*
        assertThat("The main() method should do something.",
                source, RegexMatcher.matches("^.*?ExpressionStmt.*?\\/ExpressionStmt.*?$"));
    }*/
}