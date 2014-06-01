package com.blogspot.toomuchcoding.book.chapter4._2_StubbingMethodThatReturnValues.subsequent.assertj;

import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.TaxFactorFetcher;
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
public class MeanTaxFactorCalculatorTest {

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
        then(meanTaxFactor).isEqualTo(expectedMeanTaxFactor);
    }

}


