package com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages;

import com.blogspot.toomuchcoding.person.Person;

public interface TaxService {

    double getCurrentTaxFactorFor(Person person);

    double performAdditionalCalculation();
}


