package com.blogspot.toomuchcoding.book.chapter6._4_VerifyingThatInteractionsNeverHappened;

import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

@Listeners(MockitoTestNGListener.class)
public class TaxTransfererTestNgTest {

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
