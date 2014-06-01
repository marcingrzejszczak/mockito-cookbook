package com.blogspot.toomuchcoding.book.chapter4._11_StubbingStaticMethodsWithPowerMock.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.blogspot.toomuchcoding.book.chapter4.common.staticmethod.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4.common.staticmethod.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TaxFactorFetcher.class)
public class MeanTaxFactorCalculatorTest {    

    MeanTaxFactorCalculator systemUnderTest = new MeanTaxFactorCalculator();

    @Test
    public void should_calculate_tax_factor_for_a_player_with_undefined_country() {
        // given
	    double expectedMeanTaxFactor = 10;
        mockStatic(TaxFactorFetcher.class);
        given(TaxFactorFetcher.getTaxFactorFor(any(Person.class))).willReturn(5.5, 14.5);

        // when
        double taxFactorForPerson = systemUnderTest.calculateTaxFactorFor(new Person());

        // then
        then(taxFactorForPerson).isEqualTo(expectedMeanTaxFactor);
    }

}
