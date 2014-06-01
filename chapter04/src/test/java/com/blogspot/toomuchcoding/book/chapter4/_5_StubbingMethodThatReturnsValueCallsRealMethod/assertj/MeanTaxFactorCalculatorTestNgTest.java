package com.blogspot.toomuchcoding.book.chapter4._5_StubbingMethodThatReturnsValueCallsRealMethod.assertj;

import com.blogspot.toomuchcoding.book.chapter4._5_StubbingMethodThatReturnsValueCallsRealMethod.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4._5_StubbingMethodThatReturnsValueCallsRealMethod.TaxService;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@Listeners(MockitoTestNGListener.class)
public class MeanTaxFactorCalculatorTestNgTest {

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
        then(meanTaxFactor).isEqualTo(expectedMeanTaxFactor);
    }

}


