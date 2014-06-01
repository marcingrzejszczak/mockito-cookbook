package com.blogspot.toomuchcoding.book.chapter10._2_JMockit.nonstrict.assertj;

import static org.assertj.core.api.BDDAssertions.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter10.TaxService;
import com.blogspot.toomuchcoding.book.chapter10.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import mockit.integration.testng.Initializer;

@Listeners(Initializer.class)
public class TaxTransfererTestNgTest {

    @Test
    public void should_return_false_when_tax_was_not_transfered_and_connection_to_irs_was_refused(@Mocked final TaxService taxService) {
	    // given
	    TaxTransferer systemUnderTest = new TaxTransferer(taxService);
	    final Person person = new Person();
	    new NonStrictExpectations() {
		    {
			    taxService.hasAlreadyTransferredTax(person);
			    result = false;
			    taxService.transferTaxFor(person);
			    result = new RuntimeException("Connection refused");
		    }
	    };

	    // when
	    boolean transferSuccessful = systemUnderTest.transferTaxFor(person);

	    // then
	    then(transferSuccessful).isFalse();
	    new Verifications() {
		    {
			    taxService.hasAlreadyTransferredTax(person);
			    taxService.transferTaxFor(person);
		    }
	    };
    }

}
