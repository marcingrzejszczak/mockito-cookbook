package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice;

import com.blogspot.toomuchcoding.person.Person;
import com.google.inject.Inject;

public class TaxTransferer {

    private final TaxService taxService;

    @Inject
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
