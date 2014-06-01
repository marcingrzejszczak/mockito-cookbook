package com.blogspot.toomuchcoding.book.chapter4._5_StubbingMethodThatReturnsValueCallsRealMethod;

import com.blogspot.toomuchcoding.person.Person;

public class TaxService {

    public static final double NO_COUNTRY_TAX_FACTOR = 200;

    public static final double DEFAULT_TAX_FACTOR = 150;

    public double getTaxFactorFor(Person person) {
        if (person.isCountryDefined()) {
            return DEFAULT_TAX_FACTOR;
        }
        return NO_COUNTRY_TAX_FACTOR;
    }
}


