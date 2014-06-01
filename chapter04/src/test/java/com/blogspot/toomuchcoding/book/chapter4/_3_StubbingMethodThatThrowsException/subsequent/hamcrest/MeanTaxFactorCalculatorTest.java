package com.blogspot.toomuchcoding.book.chapter4._3_StubbingMethodThatThrowsException.subsequent.hamcrest;

import com.blogspot.toomuchcoding.book.chapter4.common.exception.InvalidTaxFactorException;
import com.blogspot.toomuchcoding.book.chapter4.common.exception.TaxServiceUnavailableException;
import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {

    @Mock TaxFactorFetcher taxFactorFetcher;

    @InjectMocks MeanTaxFactorCalculator systemUnderTest;

    @Test
    public void should_throw_exception_when_calculating_mean_tax_factor() {
        given(taxFactorFetcher.getTaxFactorFor(any(Person.class))).willThrow(new TaxServiceUnavailableException()).willThrow(new InvalidTaxFactorException());

        when(systemUnderTest).calculateMeanTaxFactorFor(new Person());

        assertThat(caughtException(), instanceOf(TaxServiceUnavailableException.class));

        when(systemUnderTest).calculateMeanTaxFactorFor(new Person());

        assertThat(caughtException(), instanceOf(InvalidTaxFactorException.class));
    }

}


