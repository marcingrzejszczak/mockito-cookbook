package com.blogspot.toomuchcoding.book.chapter5._1_StubbingMethodThatReturnValues.hamcrest;

import com.blogspot.toomuchcoding.book.chapter5.returningvalue.AverageTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter5.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.willReturn;

@RunWith(MockitoJUnitRunner.class)
public class AverageTaxFactorCalculatorTest {

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
        assertThat(avgTaxFactor, equalTo(expectedAvgTaxFactor));
    }

}


