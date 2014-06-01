package com.blogspot.toomuchcoding.book.chapter6._6_VerifyingInOrder;

import com.blogspot.toomuchcoding.person.Person;

public interface TaxService {
    void updateTaxFactor(Person person, double meanTaxFactor);
    void transferTaxFor(Person person);
}
