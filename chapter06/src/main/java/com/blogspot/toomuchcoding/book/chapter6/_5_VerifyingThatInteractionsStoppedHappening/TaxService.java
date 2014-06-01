package com.blogspot.toomuchcoding.book.chapter6._5_VerifyingThatInteractionsStoppedHappening;

import com.blogspot.toomuchcoding.person.Person;

public interface TaxService {
    void sendErrorReport();
    void transferTaxFor(Person person);
}
