package com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo;

import com.blogspot.toomuchcoding.person.Person;

public interface TaxService {

    double calculateTaxFactorFor(Person person);

    void updateTaxData(double taxFactor, Person person);

}
