package com.blogspot.toomuchcoding.book.chapter4._10_StubbingFinalMethodsWithPowerMock.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.blogspot.toomuchcoding.book.chapter4.common.finalmethod.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4.common.finalmethod.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TaxFactorFetcher.class)
public class MeanTaxFactorCalculatorTest {

    @Mock TaxFactorFetcher taxFactorFetcher;
	
    @InjectMocks MeanTaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_tax_factor_for_a_player_with_undefined_country() {
        // given
	    double expectedMeanTaxFactor = 10;
        given(taxFactorFetcher.getTaxFactorFor(any(Person.class))).willReturn(5.5, 14.5);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        then(meanTaxFactor).isEqualTo(expectedMeanTaxFactor);
    }
	
}
