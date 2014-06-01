package com.blogspot.toomuchcoding.book.chapter5.returningvalue;

import com.blogspot.toomuchcoding.person.Person;

public class TaxFactorFetcher {

    static final double NO_COUNTRY_TAX_FACTOR = 14;

    static final double DEFAULT_TAX_FACTOR = 5;

    static final double DB_TAX_FACTOR = 8;

    public double getTaxFactorFor(Person person) {
        if (person.isCountryDefined()) {
            return DEFAULT_TAX_FACTOR;
        }
        return NO_COUNTRY_TAX_FACTOR;
    }

    public double getTaxFactorFromDb(Person person) {
        // simulation of DB access
        return DB_TAX_FACTOR;
    }
}


