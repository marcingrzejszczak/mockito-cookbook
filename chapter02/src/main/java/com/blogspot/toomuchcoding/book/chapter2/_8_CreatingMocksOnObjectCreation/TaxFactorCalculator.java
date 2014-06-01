package com.blogspot.toomuchcoding.book.chapter2._8_CreatingMocksOnObjectCreation;

import com.blogspot.toomuchcoding.person.Person;

public class TaxFactorCalculator {

    public double calculateTaxFactorFor(Person person) {
        return new TaxWebService().calculateTaxFactorFor(person);
    }

}

