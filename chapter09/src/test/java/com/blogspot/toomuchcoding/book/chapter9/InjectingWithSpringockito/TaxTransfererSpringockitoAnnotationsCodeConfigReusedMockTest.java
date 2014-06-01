package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringockito;

import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.*;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoAnnotatedContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogspot.toomuchcoding.book.chapter9.exception.CustomException;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringockitoAnnotatedContextLoader.class, classes = TaxConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaxTransfererSpringockitoAnnotationsCodeConfigReusedMockTest {

    @Autowired TaxTransferer taxTransferer;

    @ReplaceWithMock @Autowired TaxService taxService;

	@Test
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

	@Test
	public void _2_should_fail_cause_mock_wasnt_reset_and_was_stubbed_in_previous_test() {
		// given
		Person person = new Person();

		// when
		when(taxTransferer).transferTaxFor(person);

		// then
		thenThrown(CustomException.class);
		verify(taxService).transferTaxFor(person);
	}

	@Test
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
