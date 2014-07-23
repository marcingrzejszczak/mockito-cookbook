package com.blogspot.toomuchcoding.book.chapter10._2_JMockit.nonstrict.hamcrest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter10.TaxService;
import com.blogspot.toomuchcoding.book.chapter10.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import mockit.Mocked;
import mockit.NonStrictExpectations;

public class SimplerTaxTransfererTestNgTest {

    @Test
    public void should_return_false_when_tax_was_not_transfered_and_connection_to_irs_was_refused(@Mocked final TaxService taxService) {
	    // given
	    TaxTransferer systemUnderTest = new TaxTransferer(taxService);
	    final Person person = new Person();
	    new NonStrictExpectations() {
		    {
			    taxService.hasAlreadyTransferredTax(person);
			    result = false;
                times = 1;
                
			    taxService.transferTaxFor(person);
			    result = new RuntimeException("Connection refused");
                times = 1;
		    }
	    };

	    // when
	    boolean transferSuccessful = systemUnderTest.transferTaxFor(person);

	    // then
        assertThat(transferSuccessful, is(false));
    }

}
