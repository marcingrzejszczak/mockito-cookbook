package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringComponentScan;

import com.blogspot.toomuchcoding.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaxTransferer {

    @Autowired private TaxService taxService;

    public boolean transferTaxFor(Person person) {
        if (person == null) {
            return false;
        }
        taxService.transferTaxFor(person);
        return true;
    }

}
