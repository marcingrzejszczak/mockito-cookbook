package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.assertj;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxTransferer;
import com.blogspot.toomuchcoding.book.chapter9.exception.CustomException;
import com.blogspot.toomuchcoding.person.Person;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.thenThrown;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.*;

/**
 * Added prefixes to test method names to ensure method execution order
 */
@Guice(modules = ReusedMockModule.class)
public class TaxTransfererReusedMockTestNgTest {

    @Inject
    TaxTransferer taxTransferer;

    @Inject
    TaxService taxService;

	@Test(priority = 1)
	public void _1_should_fail_to_transfer_tax_for_person() {
		// given
		Person person = new Person();
		willThrow(CustomException.class).given(taxService).transferTaxFor(any(Person.class));

		// when
		when(taxTransferer).transferTaxFor(person);

		// then
		thenThrown(CustomException.class);
		verify(taxService).transferTaxFor(person);
	}

	@Test(priority = 2)
	public void _2_should_fail_cause_mock_wasnt_reset_and_was_stubbed_in_previous_test() {
		// given
		Person person = new Person();

		// when
		when(taxTransferer).transferTaxFor(person);

		// then
		thenThrown(CustomException.class);
		verify(taxService).transferTaxFor(person);
	}

	@Test(priority = 3)
	public void _3_should_transfer_tax_for_person_cause_mock_is_reset() {
		// given
		Person person = new Person();
		reset(taxService);

		// when
		boolean transferSuccessful = taxTransferer.transferTaxFor(person);

		// then
		then(transferSuccessful).isTrue();
		verify(taxService).transferTaxFor(person);
	}

}
