package com.blogspot.toomuchcoding.book.chapter6._4_VerifyingThatInteractionsNeverHappened;

import com.blogspot.toomuchcoding.book.chapter6._4_VerifyingThatInteractionsNeverHappened.TaxService;
import com.blogspot.toomuchcoding.book.chapter6._4_VerifyingThatInteractionsNeverHappened.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaxTransfererTest {

    @Mock TaxService taxService;

    @InjectMocks TaxTransferer systemUnderTest;

    @Test
    public void should_not_call_web_service_method_if_person_is_null() {
        // when
        systemUnderTest.transferTaxFor(null);

        // then
        verify(taxService, never()).transferTaxFor(any(Person.class));
    }

    @Test
    public void should_not_interact_with_web_service_in_any_way_if_person_is_null() {
        // when
        systemUnderTest.transferTaxFor(null);

        // then
        verifyZeroInteractions(taxService);
    }
}
