package com.blogspot.toomuchcoding.book.chapter10.Mockito.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter10.TaxService;
import com.blogspot.toomuchcoding.book.chapter10.TaxTransferer;
import com.blogspot.toomuchcoding.book.chapter10.exception.TaxServiceConnectionException;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class TaxTransfererTest {

    @Mock TaxService taxService;

    @InjectMocks TaxTransferer systemUnderTest;

    @Test
    public void should_return_false_when_tax_was_not_transfered_and_connection_to_irs_was_refused() {
        // given
        Person person = new Person();
	    given(taxService.hasAlreadyTransferredTax(person)).willReturn(false);
        willThrow(new TaxServiceConnectionException("Connection refused")).given(taxService).transferTaxFor(person);

        // when
        boolean transferSuccessful = systemUnderTest.transferTaxFor(person);

        // then
        then(transferSuccessful).isFalse();
	    verify(taxService).hasAlreadyTransferredTax(person);
	    verify(taxService).transferTaxFor(person);
    }

}
