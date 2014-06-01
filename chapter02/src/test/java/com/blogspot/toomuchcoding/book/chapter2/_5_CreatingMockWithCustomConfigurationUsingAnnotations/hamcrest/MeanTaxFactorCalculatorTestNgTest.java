package com.blogspot.toomuchcoding.book.chapter2._5_CreatingMockWithCustomConfigurationUsingAnnotations.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;

import java.io.Serializable;

import org.testng.annotations.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;

import com.blogspot.toomuchcoding.book.chapter2.common.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter2.common.TaxService;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;

@Listeners(MockitoTestNGListener.class)
public class MeanTaxFactorCalculatorTestNgTest {

    static final double TAX_FACTOR = 10;

    @Mock(extraInterfaces = {Serializable.class}) TaxService taxService;

    @InjectMocks MeanTaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_mean_tax_factor() {
        // given
        given(taxService.getCurrentTaxFactorFor(any(Person.class))).willReturn(TAX_FACTOR);

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
	    assertThat(meanTaxFactor, equalTo(TAX_FACTOR));
	    assertThat(taxService, instanceOf(Serializable.class));
    }

}
