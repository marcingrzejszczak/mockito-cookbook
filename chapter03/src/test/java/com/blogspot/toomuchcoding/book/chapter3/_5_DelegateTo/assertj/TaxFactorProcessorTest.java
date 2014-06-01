package com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo.assertj;

import com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo.FinalTaxService;
import com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo.TaxFactorProcessor;
import com.blogspot.toomuchcoding.book.chapter3._5_DelegateTo.TaxService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.AdditionalAnswers.delegatesTo;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorProcessorTest {

    FinalTaxService finalTaxService = new FinalTaxService();

    TaxService taxService = mock(TaxService.class, delegatesTo(finalTaxService));

    TaxFactorProcessor systemUnderTest = new TaxFactorProcessor(taxService);

    @Test
    public void should_return_default_tax_factor_for_person_from_undefined_country() {
        // given
        doNothing().when(taxService).updateTaxData(anyDouble(), any(Person.class));

        // when
        double taxFactor = systemUnderTest.processTaxFactorFor(new Person());

        // then
        then(taxFactor).isEqualTo(FinalTaxService.DEFAULT_TAX_FACTOR);
    }

}


