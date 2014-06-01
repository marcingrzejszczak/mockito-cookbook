package com.blogspot.toomuchcoding.book.chapter5._2_StubbingMethodThatThrowsException.hamcrest;

import com.blogspot.toomuchcoding.book.chapter5.exception.TaxFactorFetchException;
import com.blogspot.toomuchcoding.book.chapter5.returningvalue.AverageTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter5.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.willThrow;

@Listeners(MockitoTestNGListener.class)
public class AverageTaxFactorCalculatorTestNgTest {

	@Spy TaxFactorFetcher taxFactorFetcher;
	
	@InjectMocks AverageTaxFactorCalculator systemUnderTest;

    @Test
    public void should_throw_exception_while_trying_to_calculate_mean_tax_factor() {
        willThrow(new TaxFactorFetchException()).given(taxFactorFetcher).getTaxFactorFor(any(Person.class));
        
	    when(systemUnderTest).calculateAvgTaxFactorFor(new Person());

        assertThat(caughtException(), instanceOf(TaxFactorFetchException.class));
    }

}


