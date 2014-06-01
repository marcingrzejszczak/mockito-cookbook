package com.blogspot.toomuchcoding.book.chapter4._10_StubbingFinalMethodsWithPowerMock.hamcrest;

import com.blogspot.toomuchcoding.book.chapter4.common.finalmethod.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4.common.finalmethod.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@PrepareForTest(TaxFactorFetcher.class)
public class MeanTaxFactorCalculatorTestNgTest extends PowerMockTestCase {

	@Mock TaxFactorFetcher taxFactorFetcher;

	@InjectMocks MeanTaxFactorCalculator systemUnderTest;

	@Test
	public void should_calculate_tax_factor_for_a_player_with_undefined_country() {
		// given
		double expectedTaxFactor = 10;
		given(taxFactorFetcher.getTaxFactorFor(any(Person.class))).willReturn(5.5, 14.5);

		// when
		double taxFactorForPerson = systemUnderTest.calculateMeanTaxFactorFor(new Person());

		// then
        assertThat(taxFactorForPerson, equalTo(expectedTaxFactor));
	}

    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new PowerMockObjectFactory();
    }
}
