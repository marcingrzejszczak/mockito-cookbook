package com.blogspot.toomuchcoding.book.chapter10._2_JMockit.strict.hamcrest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter10.TaxService;
import com.blogspot.toomuchcoding.book.chapter10.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import mockit.Expectations;
import mockit.Mocked;

public class SimplerTaxTransfererTestNgTest {

    @Test
    public void should_return_false_when_exception_occurred_while_transferring_tax(@Mocked final TaxService taxService) {
        // given
        TaxTransferer systemUnderTest = new TaxTransferer(taxService);
        final Person person = new Person();
        new Expectations() {
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
        assertThat(transferSuccessful, is(false));
    }

}
