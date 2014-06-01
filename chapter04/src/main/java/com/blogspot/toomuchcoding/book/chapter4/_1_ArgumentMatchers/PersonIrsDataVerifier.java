package com.blogspot.toomuchcoding.book.chapter4._1_ArgumentMatchers;

import com.blogspot.toomuchcoding.person.Person;

public class PersonIrsDataVerifier {

    private final IrsDataFetcher irsDataFetcher;

    public PersonIrsDataVerifier(IrsDataFetcher irsDataFetcher) {
        this.irsDataFetcher = irsDataFetcher;
    }

    public boolean isIrsDepartmentApplicable(Person person, String city) {
        boolean irsDptApplicable = irsDataFetcher.isIrsApplicable(person, city);
        System.out.printf("IRS department is applicable [%s] for person [%s] and city [%s]%n", irsDptApplicable, person.getName(), city);
        return irsDptApplicable;
    }

}
