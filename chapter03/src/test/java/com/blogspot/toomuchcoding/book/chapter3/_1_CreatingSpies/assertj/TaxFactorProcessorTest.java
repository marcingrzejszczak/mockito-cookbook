package com.blogspot.toomuchcoding.book.chapter3._1_CreatingSpies.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.blogspot.toomuchcoding.book.chapter3.common.TaxFactorProcessor;
import com.blogspot.toomuchcoding.book.chapter3.common.TaxService;
import com.blogspot.toomuchcoding.person.Person;

public class TaxFactorProcessorTest {

    TaxService taxService = spy(new TaxService());

    TaxFactorProcessor systemUnderTest = new TaxFactorProcessor(taxService);

    @Test
    public void should_return_default_tax_factor_for_person_from_undefined_country() {
        // given
        doNothing().when(taxService).updateTaxData(anyDouble(), any(Person.class));

        // when
        double taxFactor = systemUnderTest.processTaxFactorFor(new Person());

        // then
        then(taxFactor).isEqualTo(TaxService.DEFAULT_TAX_FACTOR);
    }

}


