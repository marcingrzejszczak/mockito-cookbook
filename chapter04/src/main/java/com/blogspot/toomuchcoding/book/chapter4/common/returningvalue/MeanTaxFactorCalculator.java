package com.blogspot.toomuchcoding.book.chapter4.common.returningvalue;

import com.blogspot.toomuchcoding.person.Person;

public class MeanTaxFactorCalculator {

    private final TaxFactorFetcher taxFactorFetcher;

    public MeanTaxFactorCalculator(TaxFactorFetcher taxFactorFetcher) {
        this.taxFactorFetcher = taxFactorFetcher;
    }

    public double calculateMeanTaxFactorFor(Person person) {
        double taxFactor = taxFactorFetcher.getTaxFactorFor(person);
        double anotherTaxFactor = taxFactorFetcher.getTaxFactorFor(person);
        return (taxFactor + anotherTaxFactor) / 2;
    }

}
