package com.blogspot.toomuchcoding.book.chapter6._7_VerifyingIgnoringStubs.assertj;

import com.blogspot.toomuchcoding.book.chapter6._7_VerifyingIgnoringStubs.TaxService;
import com.blogspot.toomuchcoding.book.chapter6._7_VerifyingIgnoringStubs.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaxTransfererTest {

    @Mock TaxService taxService;

    @InjectMocks TaxTransferer systemUnderTest;

	@Test
	public void should_verify_that_ignoring_stubbed_method_there_was_a_single_interaction_with_mock() {
		// given
		Person person = new Person();
		given(taxService.sendStatisticsReport()).willReturn(true);

		// when
		boolean success = systemUnderTest.transferTaxFor(person);

		// then
		verify(taxService).transferTaxFor(person);
		verifyNoMoreInteractions(ignoreStubs(taxService));
		then(success).isTrue();
	}

    /** contains expected only for the test to pass **/
    @Test(expected = NoInteractionsWanted.class)
    public void should_fail_on_verifying_no_more_interactions_due_to_existing_stubbing() {
        // given
        Person person = new Person();
        given(taxService.sendStatisticsReport()).willReturn(true);

        // when
        boolean success = systemUnderTest.transferTaxFor(person);

        // then
        verify(taxService).transferTaxFor(person);
        verifyNoMoreInteractions(taxService);
	    then(success).isTrue();
    }

}
