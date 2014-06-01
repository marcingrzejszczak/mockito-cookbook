package com.blogspot.toomuchcoding.book.chapter10._1_Easymock.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.easymock.EasyMock.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.blogspot.toomuchcoding.book.chapter10.TaxService;
import com.blogspot.toomuchcoding.book.chapter10.TaxTransferer;
import com.blogspot.toomuchcoding.book.chapter10.exception.TaxServiceConnectionException;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(EasyMockRunner.class)
public class TaxTransfererTest {

    @Mock TaxService taxService;

	TaxTransferer systemUnderTest;	
	
    @Test
    public void should_return_false_when_tax_was_not_transfered_and_connection_to_irs_was_refused() {
        // expect
	    systemUnderTest =  new TaxTransferer(taxService);	    
        Person person = new Person();
	    expect(taxService.hasAlreadyTransferredTax(eq(person))).andReturn(false);
        taxService.transferTaxFor(eq(person));
        expectLastCall().andThrow(new TaxServiceConnectionException("Connection refused"));
        replay(taxService);

        // act
        boolean transferSuccessful = systemUnderTest.transferTaxFor(person);

        // assert
        then(transferSuccessful).isFalse();
	    verify(taxService);
    }

}
