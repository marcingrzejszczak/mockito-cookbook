package com.blogspot.toomuchcoding.book.chapter5._2_StubbingMethodThatThrowsException.assertj;

import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.*;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter5.exception.TaxFactorFetchException;
import com.blogspot.toomuchcoding.book.chapter5.returningvalue.AverageTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter5.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class AverageTaxFactorCalculatorTest {

	@Spy TaxFactorFetcher taxFactorFetcher;
	
	@InjectMocks AverageTaxFactorCalculator systemUnderTest;

    @Test
    public void should_throw_exception_while_trying_to_calculate_mean_tax_factor() {
        willThrow(new TaxFactorFetchException()).given(taxFactorFetcher).getTaxFactorFor(any(Person.class));
        
	    when(systemUnderTest).calculateAvgTaxFactorFor(new Person());
        
        thenThrown(TaxFactorFetchException.class);	    
    }

}


