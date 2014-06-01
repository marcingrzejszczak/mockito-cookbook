package com.blogspot.toomuchcoding.book.chapter4._12_StubbingObjectInstantiationWithPowerMock;

import com.blogspot.toomuchcoding.person.Person;

public class MeanTaxFactorCalculator {

    public double calculateMeanTaxFactorFor(Person person) {
	    TaxFactorFetcher taxFactorFetcher = new TaxFactorFetcher();
        double taxFactor = taxFactorFetcher.getTaxFactorFor(person);
        double anotherTaxFactor = taxFactorFetcher.getTaxFactorFor(person);
        return (taxFactor + anotherTaxFactor) / 2;
    }

}
