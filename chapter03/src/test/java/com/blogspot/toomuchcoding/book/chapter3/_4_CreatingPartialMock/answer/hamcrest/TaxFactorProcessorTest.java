package com.blogspot.toomuchcoding.book.chapter3._4_CreatingPartialMock.answer.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Answers.CALLS_REAL_METHODS;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

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

    @Mock(answer = CALLS_REAL_METHODS) TaxService taxService;

    @InjectMocks TaxFactorProcessor systemUnderTest;

    @Test
    public void should_return_default_tax_factor_for_person_from_undefined_country() {
        // given
        doNothing().when(taxService).updateTaxData(anyDouble(), any(Person.class));

        // when
        double taxFactor = systemUnderTest.processTaxFactorFor(new Person());

        // then
	    assertThat(taxFactor, equalTo(TaxService.DEFAULT_TAX_FACTOR));
    }

}


