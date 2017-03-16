package com.theironyard;

import java.util.ArrayList;

/**
 * The ConversionService is responsible for converting values between units. It
 * also can provide a list of units it can convert between (in String form).
 *
 * This class exists because the act of converting units is distinct from other
 * actions we can perform in this application. It's conceivable that we may have
 * another application in the future that needs to be able to convert units, but
 * which can't print out menus.
 *
 * Because this conversion service has no knowledge at all of the MenuService,
 * Main, or even Scanner, we can easily reuse it elsewhere. All we need to do
 * is make sure we have the Weight enum, which ConversionService does depend on.
 *
 * Your job is to implement the methods below.
 */
public class ConversionService {

    /**
     * Create a method named listUnits(). This method accepts no arguments and
     * returns an ArrayList of String objects. The List is a list of valid units
     * that we can convert between. All of the values should be returned in
     * lowercase.
     *
     * All enums have a method, values(), that returns an array of that enum's
     * values. For example, the Weight enum's values() method will return
     * Weight[]. You should iterate over this array to create your list of unit
     * Strings.
     *
     * You can convert an enum into a string using it's toString() method. For
     * example, Weight.METRIC_TON.toString() is "METRIC_TON". Take note that
     * all Strings in the returned list must be lowercase. Also, any underscore
     * characters should be replaced with spaces. If you're not sure how to do
     * this, research the String class' toLowerCase() and replaceAll() methods.
     *
     * @return A ArrayList of lowercase Strings containing valid units. All underscores are replaced with spaces.
     */
    // todo: create listUnits() method
	public ArrayList<String> listUnits(){
		ArrayList<String> unitList = new ArrayList<>();
		for(Weight weight: Weight.values()){
			if(weight.toString().toLowerCase().contains("_")) {
				unitList.add(weight.toString().toLowerCase().replace("_"," "));
			}else {
				unitList.add(weight.toString().toLowerCase());
			}
		}

		return unitList;
	}



    /**
     * Create a method named convert(). It accepts three arguments, the number
     * being converted, the unit we're converting from, and the unit we're
     * converting to. It returns the converted value.
     *
     * For example, if we are converting 210.5 pounds to stones our arguments
     * would be:
     *
     * weight = 210.5
     * from = Weight.POUND
     * to = Weight.STONE
     *
     * The converted weight is 15.035714, so that is what would be returned.
     *
     * The process to convert is:
     *
     * 1) multiply the weight by its unit's value in grams. This tells you the
     * weight in grams. EG: 210.5 lbs in grams is 210.5 * 453.59237 = 95,481.194
     *
     * 2) divide the weight in grams by the target unit's grams. EG: A Stone is
     * 6,350.2932 grams. So, 95,481.194 grams (from pounds) / 6,350.2932 grams
     * per stone = 15.035714 stone
     *
     * @param weight a decimal number that is being converted from one unit to another
     * @param from a Weight value. EG: Weight.METRIC_TON. This is the unit we're converting from.
     * @param to a Weight value. This is the unit we're converting to.
     * @return the converted weight
     */
    // todo: create convert() method
	public double convert(double weight,Weight from, Weight to){

		return weight * from.getGrams() / to.getGrams();
	}



}
