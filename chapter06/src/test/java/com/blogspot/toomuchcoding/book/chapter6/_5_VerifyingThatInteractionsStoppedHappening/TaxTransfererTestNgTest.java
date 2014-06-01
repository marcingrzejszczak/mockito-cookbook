package com.blogspot.toomuchcoding.book.chapter6._5_VerifyingThatInteractionsStoppedHappening;

import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
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
