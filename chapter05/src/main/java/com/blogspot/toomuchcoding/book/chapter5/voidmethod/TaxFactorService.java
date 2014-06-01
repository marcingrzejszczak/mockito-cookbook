package com.blogspot.toomuchcoding.book.chapter5.voidmethod;

import java.net.ConnectException;

import com.blogspot.toomuchcoding.person.Person;

public class TaxFactorService {

    private static final double MEAN_TAX_FACTOR = 0.5;

    public void updateMeanTaxFactor(Person person, double meanTaxFactor) throws ConnectException {
	    System.out.printf("Updating mean tax factor [%s] for person with defined country%n", meanTaxFactor);
    }

    public double calculateMeanTaxFactor() {
	    return MEAN_TAX_FACTOR;
    }

}


