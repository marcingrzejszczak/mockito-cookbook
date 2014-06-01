package com.blogspot.toomuchcoding.book.chapter2._7_MockingEnums.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter2._7_MockingEnums.Country;
import com.blogspot.toomuchcoding.book.chapter2._7_MockingEnums.TaxFactorCalculator;
import com.blogspot.toomuchcoding.person.Person;

@PrepareForTest(Country.class)
public class TaxFactorCalculatorTestNgTest extends PowerMockTestCase {

    static final double TAX_FACTOR = 10000;

    @Mock Country country;

    @InjectMocks TaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_tax_factor() {
        // given
        mockStatic(Country.class);
        given(Country.fromCountryName(anyString())).willReturn(country);
        given(country.calculateTaxFactorFor(any(Person.class))).willReturn(TAX_FACTOR);

        // when
        double taxFactorForPerson = systemUnderTest.calculateTaxFactorFor(new Person());

        // then
	    assertThat(taxFactorForPerson, equalTo(TAX_FACTOR));
    }

    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new PowerMockObjectFactory();
    }

}
