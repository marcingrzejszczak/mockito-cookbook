package com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.hamcrest;

import com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.TaxFactorCalculator;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TaxFactorCalculatorTestNgTest {

    @Test
    public void should_calculate_sum_of_factors() {
        // given
        TaxFactorCalculator systemUnderTest = new TaxFactorCalculator();
        double taxFactorOne = 1;
        double taxFactorTwo = 2;
        double expectedSum = 3;

        // when
        double sumOfFactors = systemUnderTest.calculateSum(taxFactorOne, taxFactorTwo);

        // then
	    assertThat(sumOfFactors, equalTo(expectedSum));
    }

}
