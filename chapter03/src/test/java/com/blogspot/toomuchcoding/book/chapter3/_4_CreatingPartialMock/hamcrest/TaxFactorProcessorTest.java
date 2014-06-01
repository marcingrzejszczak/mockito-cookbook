package com.blogspot.toomuchcoding.book.chapter3._4_CreatingPartialMock.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter3.common.TaxFactorProcessor;
import com.blogspot.toomuchcoding.book.chapter3.common.TaxService;
import com.blogspot.toomuchcoding.person.Person;

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
	    assertThat(taxFactor, equalTo(TaxService.DEFAULT_TAX_FACTOR));
    }

}


