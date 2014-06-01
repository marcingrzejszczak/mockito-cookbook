package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringockito;

import com.blogspot.toomuchcoding.person.Person;

class TaxService {

    public void transferTaxFor(Person person) {
        System.out.printf("Calling external web service for person with name [%s]%n", person.getName());
    }

}
