package com.blogspot.toomuchcoding.book.chapter2._5_CreatingMockWithCustomConfigurationUsingAnnotations.assertj;

import com.blogspot.toomuchcoding.book.chapter2.common.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter2.common.TaxService;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

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
        then(meanTaxFactor).isEqualTo(TAX_FACTOR);
	    then(taxService).isInstanceOf(Serializable.class);
    }

}
