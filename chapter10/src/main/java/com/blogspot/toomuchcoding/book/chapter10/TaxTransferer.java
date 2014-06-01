package com.blogspot.toomuchcoding.book.chapter10;

import com.blogspot.toomuchcoding.person.Person;

public class TaxTransferer {

	private final TaxService taxService;

	public TaxTransferer(TaxService taxService) {
		this.taxService = taxService;
	}

	public boolean transferTaxFor(Person person) {
		if (taxService.hasAlreadyTransferredTax(person)) {
			return false;
		}		
		try {
			taxService.transferTaxFor(person);
		} catch (Exception exception) {
			System.out.printf("Exception [%s] caught while trying to transfer tax for [%s]%n", exception, person.getName());
			return false;
		}
		return true;
	}

}
