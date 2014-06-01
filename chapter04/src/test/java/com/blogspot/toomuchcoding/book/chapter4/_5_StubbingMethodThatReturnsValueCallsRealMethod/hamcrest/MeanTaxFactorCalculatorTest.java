package com.blogspot.toomuchcoding.book.chapter4._5_StubbingMethodThatReturnsValueCallsRealMethod.hamcrest;

import com.blogspot.toomuchcoding.book.chapter4._5_StubbingMethodThatReturnsValueCallsRealMethod.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4._5_StubbingMethodThatReturnsValueCallsRealMethod.TaxService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {

    @Mock TaxService taxService;

    @InjectMocks MeanTaxFactorCalculator systemUnderTest;

    @Test
    public void should_return_mean_tax_factor() {
        // given
        double taxFactor = 15000;
        double expectedMeanTaxFactor = (TaxService.NO_COUNTRY_TAX_FACTOR + taxFactor) / 2;
        given(taxService.getTaxFactorFor(any(Person.class))).willCallRealMethod().willReturn(taxFactor);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        assertThat(meanTaxFactor, equalTo(expectedMeanTaxFactor));
    }

}


