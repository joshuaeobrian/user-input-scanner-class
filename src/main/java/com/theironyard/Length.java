package com.theironyard;


public enum Length {
    MILE(1609344),
    YARD(914.4),
    FOOT(304.8),
    INCH(25.4),
    KILOMETER(1000000),
    METER(1000),
    CENTIMETER(10),
    MILLIMETER(1);

    private final double millimeters;

    Length(double millimeters) {
        this.millimeters = millimeters;
    }

    public double getMillimeters() {
        return millimeters;
    }
}
