package com.blogspot.toomuchcoding.book.chapter5._1_StubbingMethodThatReturnValues.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter5.returningvalue.AverageTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter5.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;

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
        then(avgTaxFactor).isEqualTo(expectedAvgTaxFactor);
    }

}


