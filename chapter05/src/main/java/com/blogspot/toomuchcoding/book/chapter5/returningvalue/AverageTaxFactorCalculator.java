package com.blogspot.toomuchcoding.book.chapter5.returningvalue;

import com.blogspot.toomuchcoding.person.Person;

public class AverageTaxFactorCalculator {

    private final TaxFactorFetcher taxFactorFetcher;

    public AverageTaxFactorCalculator(TaxFactorFetcher taxFactorFetcher) {
        this.taxFactorFetcher = taxFactorFetcher;
    }

    public double calculateAvgTaxFactorFor(Person person) {
        double taxFactor = taxFactorFetcher.getTaxFactorFromDb(person);
        double anotherTaxFactor = taxFactorFetcher.getTaxFactorFor(person);
        return (taxFactor + anotherTaxFactor) / 2;
    }

}
