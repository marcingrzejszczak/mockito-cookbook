package com.blogspot.toomuchcoding.book.chapter4._2_StubbingMethodThatReturnValues.subsequent.hamcrest;

import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@Listeners(MockitoTestNGListener.class)
public class MeanTaxFactorCalculatorTestNgTest {

    @Mock TaxFactorFetcher taxFactorFetcher;

    @InjectMocks MeanTaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_mean_tax_factor_for_two_different_tax_factors() {
        // given
        double taxFactor = 10;
        double anotherTaxFactor = 20;
        double expectedMeanTaxFactor = (taxFactor + anotherTaxFactor) / 2;
        given(taxFactorFetcher.getTaxFactorFor(any(Person.class))).willReturn(taxFactor).willReturn(anotherTaxFactor);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        assertThat(meanTaxFactor, equalTo(expectedMeanTaxFactor));
    }

}


