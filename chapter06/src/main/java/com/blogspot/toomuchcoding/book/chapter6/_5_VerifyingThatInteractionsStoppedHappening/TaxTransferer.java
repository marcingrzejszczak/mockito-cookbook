package com.blogspot.toomuchcoding.book.chapter6._5_VerifyingThatInteractionsStoppedHappening;

import com.blogspot.toomuchcoding.person.Person;

public class TaxTransferer {

    private final TaxService taxService;

    public TaxTransferer(TaxService taxService) {
        this.taxService = taxService;
    }

    public void transferTaxFor(Person person) {
        if (person == null) {
            taxService.sendErrorReport();
            return;
        }
        taxService.transferTaxFor(person);
    }

}
