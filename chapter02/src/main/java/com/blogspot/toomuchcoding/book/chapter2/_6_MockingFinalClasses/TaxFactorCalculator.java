package com.blogspot.toomuchcoding.book.chapter2._6_MockingFinalClasses;

import com.blogspot.toomuchcoding.person.Person;

public class TaxFactorCalculator {

    public static final double INVALID_TAX_FACTOR = -1;

    private final TaxService taxService;

    public TaxFactorCalculator(TaxService taxService) {
        this.taxService = taxService;
    }

    public double calculateTaxFactorFor(Person person) {
        try {
            return taxService.calculateTaxFactorFor(person);
        } catch (Exception e) {
            System.err.printf("Exception [%s] occurred while trying to calculate tax factor for person [%s]%n", e, person.getName());
            return INVALID_TAX_FACTOR;
        }
    }

}
