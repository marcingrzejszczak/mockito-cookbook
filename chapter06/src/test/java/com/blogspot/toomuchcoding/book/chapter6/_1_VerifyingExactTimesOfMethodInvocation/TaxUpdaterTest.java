package com.blogspot.toomuchcoding.book.chapter6._1_VerifyingExactTimesOfMethodInvocation;

import com.blogspot.toomuchcoding.book.chapter6.common.TaxService;
import com.blogspot.toomuchcoding.book.chapter6.common.TaxUpdater;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TaxUpdaterTest {

    @Mock TaxService taxService;

    @InjectMocks TaxUpdater systemUnderTest;

    @Test
    public void should_send_exactly_two_messages_through_the_web_service() {
        // when
        systemUnderTest.updateTaxFactorFor(new Person(), new Person());

        // then
        verify(taxService, times(2)).updateMeanTaxFactor(any(Person.class), anyDouble());
    }

}


