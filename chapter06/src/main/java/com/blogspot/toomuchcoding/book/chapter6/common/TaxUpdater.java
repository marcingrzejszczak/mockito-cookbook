package com.blogspot.toomuchcoding.book.chapter6.common;

import com.blogspot.toomuchcoding.person.Person;

public class TaxUpdater {

    static final double MEAN_TAX_FACTOR = 10.5;

    private final TaxService taxService;

    public TaxUpdater(TaxService taxService) {
        this.taxService = taxService;
    }

    public void updateTaxFactorFor(Person brother, Person sister) {
        taxService.updateMeanTaxFactor(brother, calculateMeanTaxFactor());
        taxService.updateMeanTaxFactor(sister, calculateMeanTaxFactor());
    }

    private double calculateMeanTaxFactor() {
        return MEAN_TAX_FACTOR;
    }

}
