package com.blogspot.toomuchcoding.book.chapter6._5_VerifyingThatInteractionsStoppedHappening;

import com.blogspot.toomuchcoding.book.chapter6._5_VerifyingThatInteractionsStoppedHappening.TaxService;
import com.blogspot.toomuchcoding.book.chapter6._5_VerifyingThatInteractionsStoppedHappening.TaxTransferer;
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
    public void should_only_send_error_report_if_person_is_null() throws Exception {
        // when
        systemUnderTest.transferTaxFor(null);

        // then
        verify(taxService, only()).sendErrorReport();
    }

    @Test
    public void should_only_send_error_report_if_person_is_null_in_an_ugly_way() throws Exception {
        // when
        systemUnderTest.transferTaxFor(null);

        // then
        verify(taxService).sendErrorReport();
        verifyNoMoreInteractions(taxService);
    }
}
