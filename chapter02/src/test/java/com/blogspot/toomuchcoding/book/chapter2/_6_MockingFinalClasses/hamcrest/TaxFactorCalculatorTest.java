package com.blogspot.toomuchcoding.book.chapter2._6_MockingFinalClasses.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.blogspot.toomuchcoding.book.chapter2._6_MockingFinalClasses.TaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter2._6_MockingFinalClasses.TaxService;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TaxService.class)
public class TaxFactorCalculatorTest {

    static final double TAX_FACTOR = 10000;

    @Mock TaxService taxService;

    @InjectMocks TaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_tax_factor() {
        // given
        given(taxService.calculateTaxFactorFor(Mockito.any(Person.class))).willReturn(TAX_FACTOR);

        // when
        double taxFactorForPerson = systemUnderTest.calculateTaxFactorFor(new Person());

        // then
	    assertThat(taxFactorForPerson, equalTo(TAX_FACTOR));
    }

}
