package com.blogspot.toomuchcoding.book.chapter4._4_StubbingMethodThatReturnsCustomAnswer.assertj;

import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter4.common.returningvalue.TaxFactorFetcher;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class MeanTaxFactorCalculatorTest {

    @Mock TaxFactorFetcher taxFactorFetcher;

    @InjectMocks MeanTaxFactorCalculator systemUnderTest;

    @Test
    public void should_return_tax_factor_incremented_by_additional_factor_when_calculating_mean_tax_factor() {
        // given
        final double additionalTaxFactor = 100;
        final double factorForPersonFromUndefinedCountry = 200;
        given(taxFactorFetcher.getTaxFactorFor(any(Person.class))).willAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                if (invocation.getArguments().length > 0) {
                    Person person = (Person) invocation.getArguments()[0];
                    if (!person.isCountryDefined()) {
                        return additionalTaxFactor + factorForPersonFromUndefinedCountry;
                    }
                }
                return additionalTaxFactor;
            }
        });

        // when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());

        // then
        then(meanTaxFactor).isEqualTo(additionalTaxFactor + factorForPersonFromUndefinedCountry);
    }

}


