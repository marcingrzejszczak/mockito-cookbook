package com.blogspot.toomuchcoding.book.chapter4._2_StubbingMethodThatReturnValues.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {

    @Mock TaxFactorFetcher taxFactorFetcher;

    @InjectMocks MeanTaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_mean_tax_factor() {
        // given
        double expectedTaxFactor = 10;
        given(taxFactorFetcher.getTaxFactorFor(any(Person.class))).willReturn(expectedTaxFactor);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        then(meanTaxFactor).isEqualTo(expectedTaxFactor);
    }

}


