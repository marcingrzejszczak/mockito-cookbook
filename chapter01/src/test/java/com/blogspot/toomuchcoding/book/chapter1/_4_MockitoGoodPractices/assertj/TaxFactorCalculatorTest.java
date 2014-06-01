package com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.assertj;

import org.junit.Test;

import static org.assertj.core.api.BDDAssertions.then;

import com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.TaxFactorCalculator;

public class TaxFactorCalculatorTest {

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
        then(sumOfFactors).isEqualTo(expectedSum);
    }

}
