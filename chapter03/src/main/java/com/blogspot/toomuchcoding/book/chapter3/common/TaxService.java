package com.blogspot.toomuchcoding.book.chapter3.common;

import com.blogspot.toomuchcoding.person.Person;

public class TaxService {

    public static final double POLAND_TAX_FACTOR = 0.3;

    public static final double DEFAULT_TAX_FACTOR = 0.5;

    public static final String POLAND_COUNTRY_NAME = "Poland";

    public double calculateTaxFactorFor(Person person) {
        if (POLAND_COUNTRY_NAME.equalsIgnoreCase(person.getCountryName())) {
            return POLAND_TAX_FACTOR;
        }
        return DEFAULT_TAX_FACTOR;
    }

    public void updateTaxData(double taxFactor, Person person) {
        System.out.printf("Calling web service with tax factor [%s]to update person [%s] tax data%n", taxFactor, person.getName());
    }

}


