package com.theironyard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitConversionService {

    public List<String> listConversionTypes(){
        ArrayList<String> conversionTypes = new ArrayList<>();
        conversionTypes.add("length");
        conversionTypes.add("weight");

        return conversionTypes;
    }

    public List<String> listLengthUnits(){
        List<String> lengths = new ArrayList<>();

        for(Length length : Length.values()){
            lengths.add(length.toString().toLowerCase());
        }

        return lengths;
    }

    public List<String> listWeightUnits(){
        List<String> weights = new ArrayList<>();

        for(Weight weight : Weight.values()){
            weights.add(weight.toString().replaceAll("_", " ").toLowerCase());
        }

        return weights;
    }

    public double convert(int i, Length from, Length to) {
        return i * from.getMillimeters() / to.getMillimeters();
    }

    public double convert(int i, Weight from, Weight to) {
        return i * from.getGrams() / to.getGrams();
    }
}
