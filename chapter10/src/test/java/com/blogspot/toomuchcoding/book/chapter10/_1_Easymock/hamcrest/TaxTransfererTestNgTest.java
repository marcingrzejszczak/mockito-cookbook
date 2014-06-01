package com.blogspot.toomuchcoding.book.chapter10._1_Easymock.hamcrest;

import com.blogspot.toomuchcoding.book.chapter10.TaxService;
import com.blogspot.toomuchcoding.book.chapter10.TaxTransferer;
import com.blogspot.toomuchcoding.book.chapter10.exception.TaxServiceConnectionException;
import com.blogspot.toomuchcoding.person.Person;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TaxTransfererTestNgTest {

    @Mock TaxService taxService;

    TaxTransferer systemUnderTest;

    @BeforeMethod
    public void setup() {
        EasyMockSupport.injectMocks(this);
	    systemUnderTest = new TaxTransferer(taxService);
    }

    @Test
    public void should_return_false_when_tax_was_not_transfered_and_connection_to_irs_was_refused() {
        // expect
	    Person person = new Person();
	    expect(taxService.hasAlreadyTransferredTax(eq(person))).andReturn(false);
	    taxService.transferTaxFor(eq(person));
	    expectLastCall().andThrow(new TaxServiceConnectionException("Connection refused"));
	    replay(taxService);

	    // act
	    boolean transferSuccessful = systemUnderTest.transferTaxFor(person);

	    // assert
        assertThat(transferSuccessful, is(false));
	    verify(taxService);
    }

}
