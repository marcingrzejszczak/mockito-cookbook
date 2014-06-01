package com.blogspot.toomuchcoding.book.chapter6._6_VerifyingInOrder;

import com.blogspot.toomuchcoding.person.Person;

public class TaxUpdater {

    public static final int TAX_FACTOR = 100;

    private final TaxService taxService;

    public TaxUpdater(TaxService taxService) {
        this.taxService = taxService;
    }

    public void transferTaxFor(Person person) {
        taxService.updateTaxFactor(person, calculateTaxFactor(1));
        taxService.transferTaxFor(person);
        taxService.transferTaxFor(person);
        taxService.updateTaxFactor(person, calculateTaxFactor(2));
        taxService.transferTaxFor(person);
    }

    private double calculateTaxFactor(double ratio) {
        return TAX_FACTOR * ratio;
    }

}
