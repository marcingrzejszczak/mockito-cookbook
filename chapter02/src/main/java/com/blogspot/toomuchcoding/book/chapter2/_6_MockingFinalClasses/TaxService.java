package com.blogspot.toomuchcoding.book.chapter2._6_MockingFinalClasses;

import com.blogspot.toomuchcoding.person.Person;

public final class TaxService {

    public static final double POLAND_TAX_FACTOR = 0.3;

    public static final double DEFAULT_TAX_FACTOR = 0.5;

    public static final String POLAND = "Poland";

    public double calculateTaxFactorFor(Person person) {
        if (POLAND.equalsIgnoreCase(person.getCountryName())) {
            return POLAND_TAX_FACTOR;
        }
        return DEFAULT_TAX_FACTOR;
    }

}


