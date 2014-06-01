package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpring;

import com.blogspot.toomuchcoding.person.Person;

public class TaxTransferer {

    private final TaxService taxService;

    public TaxTransferer(TaxService taxService) {
        this.taxService = taxService;
    }

    public boolean transferTaxFor(Person person) {
        if (person == null) {
            return false;
        }
        taxService.transferTaxFor(person);
        return true;
    }

}
