package com.blogspot.toomuchcoding.book.chapter10._3_JMock.hamcrest;

import com.blogspot.toomuchcoding.book.chapter10.TaxService;
import com.blogspot.toomuchcoding.book.chapter10.TaxTransferer;
import com.blogspot.toomuchcoding.book.chapter10.exception.TaxServiceConnectionException;
import com.blogspot.toomuchcoding.person.Person;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TaxTransfererTest {

	/**
	 * To allow creating mocks of classes
	 */
    private Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

    TaxService taxService = context.mock(TaxService.class);

    TaxTransferer systemUnderTest = new TaxTransferer(taxService);

    @Test
    public void should_return_false_when_tax_was_not_transfered_and_connection_to_irs_was_refused() {
        // given
        final Person person = new Person();
        context.checking(new Expectations(){
	        {
	            oneOf(taxService).hasAlreadyTransferredTax(person);
		        will(returnValue(false));
		        oneOf(taxService).transferTaxFor(person);
	            will(throwException(new TaxServiceConnectionException("Connection refused")));
            }
        });

        // when
        boolean transferSuccessful = systemUnderTest.transferTaxFor(person);

        // then
        assertThat(transferSuccessful, is(false));
	    context.assertIsSatisfied();
    }

}
