package com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo;

import com.blogspot.toomuchcoding.person.Person;

public class TaxFactorProcessor {

    public static final double INVALID_TAX_FACTOR = -1;

    private final TaxService taxService;

    public TaxFactorProcessor(TaxService taxService) {
        this.taxService = taxService;
    }

    public double processTaxFactorFor(Person person) {
        try {
            double taxFactor = taxService.calculateTaxFactorFor(person);
            taxService.updateTaxData(taxFactor, person);
            return taxFactor;
        } catch (Exception e) {
            System.err.printf("Exception [%s] occurred while trying to calculate tax factor for person [%s]%n", e, person.getName());
            return INVALID_TAX_FACTOR;
        }
    }

}
