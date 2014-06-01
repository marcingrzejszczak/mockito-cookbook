package com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.assertj;

import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.*;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.*;

import javax.inject.Inject;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxTransferer;
import org.jukito.JukitoRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.blogspot.toomuchcoding.book.chapter9.exception.CustomException;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(JukitoRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaxTransfererReusedMockTest {

    @Inject
    TaxTransferer taxTransferer;

	@Test
	public void _1_should_fail_to_transfer_tax_for_person(TaxService taxService) {
		// given
		Person person = new Person();
		willThrow(CustomException.class).given(taxService).transferTaxFor(any(Person.class));

		// when
		when(taxTransferer).transferTaxFor(person);

		// then
		thenThrown(CustomException.class);
		verify(taxService).transferTaxFor(person);
	}

	@Test
	public void _2_should_transfer_tax_for_person_since_mocks_are_created_separately_for_each_test(TaxService taxService) {
		// given
		Person person = new Person();

		// when
		boolean transferSuccessful = taxTransferer.transferTaxFor(person);

		// then
		then(transferSuccessful).isTrue();
		verify(taxService).transferTaxFor(person);
	}

}
