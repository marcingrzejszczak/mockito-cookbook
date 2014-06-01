package com.blogspot.toomuchcoding.book.chapter5._5_StubbingVoidMethodThatThrowsException.assertj;

import static com.googlecode.catchexception.CatchException.*;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.*;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;
import static org.mockito.BDDMockito.*;

import java.net.ConnectException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter5.voidmethod.PersonDataUpdator;
import com.blogspot.toomuchcoding.book.chapter5.voidmethod.TaxFactorService;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonDataUpdatorTest {

	@Spy TaxFactorService taxFactorService;

    @InjectMocks PersonDataUpdator systemUnderTest;

    @Test
    public void should_fail_to_update_tax_factor_for_person_due_to_connection_issues() throws ConnectException {        
        willThrow(ConnectException.class).given(taxFactorService).updateMeanTaxFactor(any(Person.class), anyDouble());

	    when(systemUnderTest).processTaxDataFor(new Person());
	    	    
	    then(caughtException()).hasCauseInstanceOf(ConnectException.class);
    }
	
}


