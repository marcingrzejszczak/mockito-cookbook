package com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.fancy;

import com.blogspot.toomuchcoding.book.chapter1._4_MockitoGoodPractices.Calculator;

public class TaxFactorCalculator {

    private final Calculator calculator;

    public TaxFactorCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public double calculateSum(double taxFactorOne, double taxFactorTwo) {
        return calculator.add(taxFactorOne, taxFactorTwo);
    }

}