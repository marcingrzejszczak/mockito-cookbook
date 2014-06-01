package com.blogspot.toomuchcoding.book.chapter3._4_CreatingPartialMock.assertj;

import com.blogspot.toomuchcoding.book.chapter3.common.TaxFactorProcessor;
import com.blogspot.toomuchcoding.book.chapter3.common.TaxService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorProcessorTest {

    @Mock TaxService taxService;

    @InjectMocks TaxFactorProcessor systemUnderTest;

    @Test
    public void should_return_default_tax_factor_for_person_from_undefined_country() {
        // given
        given(taxService.calculateTaxFactorFor(any(Person.class))).willCallRealMethod();

        // when
        double taxFactor = systemUnderTest.processTaxFactorFor(new Person());

        // then
        then(taxFactor).isEqualTo(TaxService.DEFAULT_TAX_FACTOR);
    }

}


