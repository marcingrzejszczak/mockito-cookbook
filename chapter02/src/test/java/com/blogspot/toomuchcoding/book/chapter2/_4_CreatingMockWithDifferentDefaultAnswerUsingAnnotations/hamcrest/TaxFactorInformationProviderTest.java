package com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations.TaxFactorInformationProvider;
import com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations.TaxService;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class TaxFactorInformationProviderTest {

    @Mock(answer = Answers.RETURNS_SMART_NULLS) TaxService taxService;

    @InjectMocks TaxFactorInformationProvider systemUnderTest;

    @Test
    public void should_calculate_mean_tax_factor() {
        // when
        String parsedIrsAddress = systemUnderTest.formatIrsAddress(new Person());

        // then
	    assertThat(parsedIrsAddress, equalTo("IRS:[]"));
    }

}
