package com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages.verbose.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.VerboseMockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter1._5_AddingMockitoHintsToExceptionMessages.TaxService;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(VerboseMockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {

    /**
     * VerboseMockitoJUnitRunner appends a listener that changes the failure's exception in a very hacky way...
     * <p/>
     * - Finds all unused stubs for given mocks
     * - Finds all stubs
     * - Prints additional warning msg - it might help in finding the reasons
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
