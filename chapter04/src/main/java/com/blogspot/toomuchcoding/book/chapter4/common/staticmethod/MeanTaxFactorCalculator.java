package com.blogspot.toomuchcoding.book.chapter4.common.staticmethod;

import com.blogspot.toomuchcoding.person.Person;

public class MeanTaxFactorCalculator {

    public double calculateTaxFactorFor(Person person) {
        double taxFactor = TaxFactorFetcher.getTaxFactorFor(person);
        double anotherTaxFactor = TaxFactorFetcher.getTaxFactorFor(person);
        return (taxFactor + anotherTaxFactor) / 2;
    }

}
