package com.blogspot.toomuchcoding.book.chapter5._1_StubbingMethodThatReturnValues.assertj;

import com.blogspot.toomuchcoding.book.chapter5.returningvalue.AverageTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter5.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.willReturn;

@Listeners(MockitoTestNGListener.class)
public class AverageTaxFactorCalculatorTestNgTest {

    @Spy TaxFactorFetcher taxFactorFetcher;

    @InjectMocks AverageTaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_avg_tax_factor_for_person_without_a_country() {
        // given
	    double storedTaxFactor = 10;
	    double expectedAvgTaxFactor = 12;
	    willReturn(storedTaxFactor).given(taxFactorFetcher).getTaxFactorFromDb(any(Person.class));

        // when
        double avgTaxFactor = systemUnderTest.calculateAvgTaxFactorFor(new Person());

        // then
        then(avgTaxFactor).isEqualTo(expectedAvgTaxFactor);
    }

}


