package com.blogspot.toomuchcoding.book.chapter4._5_StubbingMethodThatReturnsValueCallsRealMethod;

import com.blogspot.toomuchcoding.person.Person;

public class MeanTaxFactorCalculator {

    private final TaxService taxService;

    public MeanTaxFactorCalculator(TaxService taxService) {
        this.taxService = taxService;
    }

    public double calculateMeanTaxFactorFor(Person person) {
        try {
            double taxFactor = taxService.getTaxFactorFor(person);
            double anotherTaxFactor = taxService.getTaxFactorFor(person);
            return (taxFactor + anotherTaxFactor) / 2;
        } catch (Exception e) {
            System.err.printf("Exception occurred while trying retrieve tax factor [%s]%n", e);
            throw new RuntimeException(e);
        }
    }

}
