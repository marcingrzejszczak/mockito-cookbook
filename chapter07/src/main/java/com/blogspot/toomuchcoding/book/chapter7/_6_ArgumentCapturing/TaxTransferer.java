package com.blogspot.toomuchcoding.book.chapter7._6_ArgumentCapturing;

import com.blogspot.toomuchcoding.person.Person;

public class TaxTransferer {

    static final String POLAND = "Poland";

    private final TaxService taxService;

    public TaxTransferer(TaxService taxService) {
        this.taxService = taxService;
    }

    public void transferTaxFor(Person person) {
        if (person == null) {
            return;
        }
        taxService.transferTaxFor(makePersonPolish(person));
    }

    private Person makePersonPolish(Person person) {
        return new Person(person, POLAND);
    }

}
