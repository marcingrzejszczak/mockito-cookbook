package com.blogspot.toomuchcoding.book.chapter5._4_StubbingVoidMethod.donothing.hamcrest;

import com.blogspot.toomuchcoding.book.chapter5.voidmethod.PersonDataUpdator;
import com.blogspot.toomuchcoding.book.chapter5.voidmethod.TaxFactorService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.ConnectException;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;

@RunWith(MockitoJUnitRunner.class)
public class PersonDataUpdatorTest {

    @Spy TaxFactorService taxFactorService;

    @InjectMocks PersonDataUpdator systemUnderTest;

    @Test
    public void should_first_fail_then_succeed_to_process_tax_factor_for_person() throws ConnectException {
        // given
        willThrow(new ConnectException()).willNothing().given(taxFactorService).updateMeanTaxFactor(any(Person.class), anyDouble());
	    
	    // when
	    when(systemUnderTest).processTaxDataFor(new Person());

	    // then
        assertThat(caughtException(), notNullValue());
        assertThat(caughtException().getCause(), instanceOf(ConnectException.class));

	    // when
	    boolean success = systemUnderTest.processTaxDataFor(new Person());

	    // then
	    assertThat(success, is(true));
    }
	
}


