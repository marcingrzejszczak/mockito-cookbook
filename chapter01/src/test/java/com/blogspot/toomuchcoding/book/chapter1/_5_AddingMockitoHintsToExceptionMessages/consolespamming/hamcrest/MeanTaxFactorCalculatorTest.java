package com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages.consolespamming.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.ConsoleSpammingMockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages.TaxService;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(ConsoleSpammingMockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {

    /**
     * ConsoleSpammingMockitoJUnitRunner appends a listener that logs additional warning messages to the console
     */
    static final double UNUSED_VALUE = 10;

    @Test(expected = AssertionError.class)
    public void should_calculate_mean_tax_factor() {
        // given
        TaxService taxService = given(Mockito.mock(TaxService.class).performAdditionalCalculation()).willReturn(UNUSED_VALUE).getMock();
        MeanTaxFactorCalculator systemUnderTest = new MeanTaxFactorCalculator(taxService);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
	    assertThat(meanTaxFactor, equalTo(UNUSED_VALUE));
    }


}
