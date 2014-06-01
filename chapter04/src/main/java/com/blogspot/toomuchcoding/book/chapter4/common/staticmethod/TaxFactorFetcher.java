package com.blogspot.toomuchcoding.book.chapter4.common.staticmethod;

import com.blogspot.toomuchcoding.person.Person;

public class TaxFactorFetcher {

    public static final double NO_COUNTRY_TAX_FACTOR = 0.3;

    public static final double DEFAULT_TAX_FACTOR = 0.5;

    public static double getTaxFactorFor(Person person) {
        if (person.isCountryDefined()) {
            return DEFAULT_TAX_FACTOR;
        }
        return NO_COUNTRY_TAX_FACTOR;
    }

}


