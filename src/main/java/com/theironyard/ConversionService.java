package com.theironyard;


import java.util.ArrayList;
import java.util.List;

public class ConversionService {

    public List<String> listUnits(){
        List<String> weights = new ArrayList<>();

        for(Weight weight : Weight.values()){
            weights.add(weight.toString().replaceAll("_", " ").toLowerCase());
        }

        return weights;
    }

    public double convert(double weight, Weight from, Weight to) {
        return weight * from.getGrams() / to.getGrams();
    }
}
