package com.blogspot.toomuchcoding.book.chapter6._2_VerifyingAtLeastTimesOfMethodInvocation;

import com.blogspot.toomuchcoding.book.chapter6.common.TaxService;
import com.blogspot.toomuchcoding.book.chapter6.common.TaxUpdater;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

@Listeners(MockitoTestNGListener.class)
public class TaxUpdaterTestNgTest {

    @Mock TaxService taxService;

    @InjectMocks TaxUpdater systemUnderTest;

    @Test
    public void should_send_at_least_two_messages_through_the_web_service() {
        // when
        systemUnderTest.updateTaxFactorFor(new Person(), new Person());

        // then
        verify(taxService, atLeast(2)).updateMeanTaxFactor(any(Person.class), anyDouble());
    }

    @Test
    public void should_send_at_least_one_message_through_the_web_service_using_atleast_once() {
        // when
        systemUnderTest.updateTaxFactorFor(new Person(), new Person());

        // then
        verify(taxService, atLeastOnce()).updateMeanTaxFactor(any(Person.class), anyDouble());
    }

}


