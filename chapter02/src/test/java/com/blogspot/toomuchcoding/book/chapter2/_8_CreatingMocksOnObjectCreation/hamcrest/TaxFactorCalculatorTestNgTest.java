package com.blogspot.toomuchcoding.book.chapter2._8_CreatingMocksOnObjectCreation.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter2._8_CreatingMocksOnObjectCreation.TaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter2._8_CreatingMocksOnObjectCreation.TaxWebService;
import com.blogspot.toomuchcoding.person.Person;

@PrepareForTest(TaxFactorCalculator.class)
public class TaxFactorCalculatorTestNgTest extends PowerMockTestCase {

    static final double TAX_FACTOR = 10000;

    @Mock TaxWebService taxWebService;

    @InjectMocks TaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_tax_factor() throws Exception {
        // given
        whenNew(TaxWebService.class).withNoArguments().thenReturn(taxWebService);
        when(taxWebService.calculateTaxFactorFor(any(Person.class))).thenReturn(TAX_FACTOR);

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
