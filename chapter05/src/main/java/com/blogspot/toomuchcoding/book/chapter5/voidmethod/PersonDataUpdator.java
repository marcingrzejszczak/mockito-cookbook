package com.blogspot.toomuchcoding.book.chapter5.voidmethod;

import java.net.ConnectException;

import com.blogspot.toomuchcoding.book.chapter5.exception.TaxFactorConnectionException;
import com.blogspot.toomuchcoding.person.Person;

public class PersonDataUpdator {

	private final TaxFactorService taxFactorService;

	public PersonDataUpdator(TaxFactorService taxFactorService) {
		this.taxFactorService = taxFactorService;
	}

	public boolean processTaxDataFor(Person person) {
		try {
			double meanTaxFactor = taxFactorService.calculateMeanTaxFactor();
			taxFactorService.updateMeanTaxFactor(person, meanTaxFactor);
			return true;
		} catch (ConnectException exception) {
			System.err.printf("Exception occurred while trying update person data [%s]%n", exception);
			throw new TaxFactorConnectionException(exception);
		}
	}

}
