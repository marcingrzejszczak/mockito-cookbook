package com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations;

import com.blogspot.toomuchcoding.person.Person;

public class TaxFactorInformationProvider {

    private final TaxService taxService;

    public TaxFactorInformationProvider(TaxService taxService) {
        this.taxService = taxService;
    }

    public String formatIrsAddress(Person person) {
        String irsAddress = taxService.getInternalRevenueServiceAddress(person.getCountryName());
        return "IRS:[" + irsAddress + "]";
    }

}
