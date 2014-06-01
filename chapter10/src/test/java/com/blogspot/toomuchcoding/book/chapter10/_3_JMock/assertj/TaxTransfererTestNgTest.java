package com.blogspot.toomuchcoding.book.chapter10._3_JMock.assertj;

import static org.assertj.core.api.BDDAssertions.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter10.TaxService;
import com.blogspot.toomuchcoding.book.chapter10.TaxTransferer;
import com.blogspot.toomuchcoding.book.chapter10.exception.TaxServiceConnectionException;
import com.blogspot.toomuchcoding.person.Person;

public class TaxTransfererTestNgTest {
	
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
	    then(transferSuccessful).isFalse();
	    context.assertIsSatisfied();
    }
}
