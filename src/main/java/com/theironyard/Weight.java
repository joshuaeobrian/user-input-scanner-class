package com.theironyard;

/**
 * The Weight enum contains constants related to weights. Each constant is has
 * a value in grams. We can use the grams as a base unit to convert between. For
 * example, if we know that there are 1,000 grams in a kilogram and 1,000,000 in
 * a metric ton, then we can determine that 1 kilogram must be 0.001 metric
 * tons.
 *
 * Follow the instructions below to build the Weight enum.
 */
public enum Weight {

    /*
        Create enum values for the following. Be sure to follow standard naming conventions!!

        1 ton = 907184.74 grams
        1 pound = 453.59237 grams
        1 ounce = 28.349523 grams
        1 stone = 6350.2932 grams
        1 metric ton = 1000000 grams
        1 kilogram = 1000 grams
        1 gram = 1 gram

        Remember that enums can call a constructor. For example:

        FURLONG(123)
     */
    // todo: create enums that call a constructor to set their weight in grams



    /**
     * Create a property that holds the enum value's weight in grams. This is
     * provided to and set by the Weight() constructor.
     */
    // todo: Create a private double property that holds the enum instance's weight in grams.


    /**
     * Create a constructor for the Weight enum. It should accept an argument
     * that sets the enum instance's weight in grams.
     * @param grams The enum instance's weight in grams.
     */
    // todo: create constructor


    /**
     * Create a method named getGrams() that accepts no arguments and returns
     * the enum's weight in grams.
     * @return The enum's weight in grams
     */
    // todo: create getGrams() method


}
