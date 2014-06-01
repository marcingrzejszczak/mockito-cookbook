package com.blogspot.toomuchcoding.book.chapter1._2_MockitoAnnotationsJunit.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.blogspot.toomuchcoding.book.chapter1.common.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter1.common.TaxService;
import com.blogspot.toomuchcoding.person.Person;

public class MeanTaxFactorCalculatorTest {

    static final double TAX_FACTOR = 10;

    @Mock TaxService taxService;

    @InjectMocks MeanTaxFactorCalculator systemUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_calculate_mean_tax_factor() {
        // given
        given(taxService.getCurrentTaxFactorFor(any(Person.class))).willReturn(TAX_FACTOR);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        then(meanTaxFactor).isEqualTo(TAX_FACTOR);
    }

}
