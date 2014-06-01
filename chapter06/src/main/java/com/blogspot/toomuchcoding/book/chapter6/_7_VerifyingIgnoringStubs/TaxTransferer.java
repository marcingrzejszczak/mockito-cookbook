package com.blogspot.toomuchcoding.book.chapter6._7_VerifyingIgnoringStubs;

import com.blogspot.toomuchcoding.person.Person;

public class TaxTransferer {

    private final TaxService taxService;

    public TaxTransferer(TaxService taxService) {
        this.taxService = taxService;
    }

    public boolean transferTaxFor(Person person) {
        if(person != null) {
            taxService.transferTaxFor(person);
        }
        return taxService.sendStatisticsReport();
    }

}
