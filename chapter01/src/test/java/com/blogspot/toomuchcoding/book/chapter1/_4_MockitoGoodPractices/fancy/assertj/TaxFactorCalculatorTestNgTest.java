package com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.fancy.assertj;

import com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.Calculator;
import com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.fancy.TaxFactorCalculator;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class TaxFactorCalculatorTestNgTest {

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
        then(sumOfFactors).isEqualTo(expectedSum);
    }

}
