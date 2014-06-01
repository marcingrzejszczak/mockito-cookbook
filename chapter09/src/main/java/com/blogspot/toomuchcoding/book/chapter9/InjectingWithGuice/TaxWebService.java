package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice;

import com.blogspot.toomuchcoding.person.Person;

class TaxWebService implements TaxService {

    @Override
    public void transferTaxFor(Person person) {
        System.out.printf("Calling external web service for person with name [%s]%n", person.getName());
    }

}
