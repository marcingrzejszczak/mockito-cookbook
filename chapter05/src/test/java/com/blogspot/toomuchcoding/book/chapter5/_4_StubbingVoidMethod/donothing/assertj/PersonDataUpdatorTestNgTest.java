package com.blogspot.toomuchcoding.book.chapter5._4_StubbingVoidMethod.donothing.assertj;

import com.blogspot.toomuchcoding.book.chapter5.voidmethod.PersonDataUpdator;
import com.blogspot.toomuchcoding.book.chapter5.voidmethod.TaxFactorService;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.assertj.core.api.BDDAssertions;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.ConnectException;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.then;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;

@Listeners(MockitoTestNGListener.class)
public class PersonDataUpdatorTestNgTest {

    @Spy TaxFactorService taxFactorService;

    @InjectMocks PersonDataUpdator systemUnderTest;

    @Test
    public void should_first_fail_then_succeed_to_process_tax_factor_for_person() throws ConnectException {
        // given
        willThrow(new ConnectException()).willNothing().given(taxFactorService).updateMeanTaxFactor(any(Person.class), anyDouble());
	    
	    // when
	    when(systemUnderTest).processTaxDataFor(new Person());

	    // then
        then(caughtException()).hasCauseInstanceOf(ConnectException.class);

	    // when
	    boolean success = systemUnderTest.processTaxDataFor(new Person());

	    // then
        BDDAssertions.then(success).isTrue();
    }
	
}


