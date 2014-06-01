package com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations.TaxFactorInformationProvider;
import com.blogspot.toomuchcoding.book.chapter2._4_CreatingMockWithDifferentDefaultAnswerUsingAnnotations.TaxService;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;

@Listeners(MockitoTestNGListener.class)
public class TaxFactorInformationProviderTestNgTest {

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
