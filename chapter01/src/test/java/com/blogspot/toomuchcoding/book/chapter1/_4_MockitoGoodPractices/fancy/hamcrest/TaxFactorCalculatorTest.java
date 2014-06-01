package com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.fancy.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.Calculator;
import com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.fancy.TaxFactorCalculator;

public class TaxFactorCalculatorTest {

    @Test
    public void should_calculate_sum_of_factors() {
        // given
        TaxFactorCalculator systemUnderTest = new TaxFactorCalculator(new Calculator());
        double taxFactorOne = 1;
        double taxFactorTwo = 2;
        double expectedSum = 3;

        // when
        double sumOfFactors = systemUnderTest.calculateSum(taxFactorOne, taxFactorTwo);

        // then
	    assertThat(sumOfFactors, equalTo(expectedSum));
    }

}
