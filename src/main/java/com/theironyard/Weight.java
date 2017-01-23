package com.theironyard;

/**
 * Created by doug on 1/19/17.
 */
public enum Weight {
    TON(907184.74),
    POUND(453.59237),
    OUNCE(28.349523),
    STONE(6350.2932),
    METRIC_TON(1000000),
    KILOGRAM(1000),
    GRAM(1);

    private final double grams;

    Weight(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }
}
