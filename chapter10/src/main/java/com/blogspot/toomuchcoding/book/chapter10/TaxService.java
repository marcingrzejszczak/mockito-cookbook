package com.blogspot.toomuchcoding.book.chapter10;

import com.blogspot.toomuchcoding.person.Person;

public class TaxService {

    public void transferTaxFor(Person person) {
        System.out.printf("Calling external web service for person with name [%s]%n", person.getName());
    }
	
	public boolean hasAlreadyTransferredTax(Person person) { return true; }

}
