package com.blogspot.toomuchcoding.book.chapter6._7_VerifyingIgnoringStubs;

import com.blogspot.toomuchcoding.person.Person;

public interface TaxService {
    boolean sendStatisticsReport();
    void transferTaxFor(Person person);
}
