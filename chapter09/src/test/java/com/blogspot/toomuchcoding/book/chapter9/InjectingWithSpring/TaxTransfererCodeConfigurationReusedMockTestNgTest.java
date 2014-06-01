package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpring;

import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.*;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter9.exception.CustomException;
import com.blogspot.toomuchcoding.person.Person;

/**
 * Added prefixes to test method names to ensure method execution order
 */
@ContextConfiguration(classes = {TaxConfiguration.class, ReusedMockTaxConfiguration.class})
public class TaxTransfererCodeConfigurationReusedMockTestNgTest  extends AbstractTestNGSpringContextTests {

    @Autowired TaxTransferer taxTransferer;

    @Autowired TaxService taxService;

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
