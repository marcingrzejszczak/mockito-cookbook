package com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.hamcrest;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxTransferer;
import com.blogspot.toomuchcoding.book.chapter9.exception.CustomException;
import com.blogspot.toomuchcoding.person.Person;
import org.jukito.JukitoRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import javax.inject.Inject;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;

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
        assertThat(caughtException(), instanceOf(CustomException.class));
		verify(taxService).transferTaxFor(person);
	}

	@Test
	public void _2_should_transfer_tax_for_person_since_mocks_are_created_separately_for_each_test(TaxService taxService) {
		// given
		Person person = new Person();

		// when
		boolean transferSuccessful = taxTransferer.transferTaxFor(person);

		// then
        assertThat(transferSuccessful, is(true));
		verify(taxService).transferTaxFor(person);
	}

}
