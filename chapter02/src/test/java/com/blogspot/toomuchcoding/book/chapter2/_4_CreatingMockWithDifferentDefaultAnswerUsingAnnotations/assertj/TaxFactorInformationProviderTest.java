package com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations.assertj;

import com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations.TaxFactorInformationProvider;
import com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations.TaxService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorInformationProviderTest {

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    TaxService taxService;

    @InjectMocks
    TaxFactorInformationProvider systemUnderTest;

    @Test
    public void should_calculate_mean_tax_factor() {
        // when
        String parsedIrsAddress = systemUnderTest.formatIrsAddress(new Person());

        // then
        then(parsedIrsAddress).isEqualTo("IRS:[]");
    }

}
