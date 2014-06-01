package com.blogspot.toomuchcoding.book.chapter5._5_StubbingVoidMethodThatThrowsException.hamcrest;

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
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonDataUpdatorTest {

	@Spy TaxFactorService taxFactorService;

    @InjectMocks PersonDataUpdator systemUnderTest;

    @Test
    public void should_fail_to_update_tax_factor_for_person_due_to_connection_issues() throws ConnectException {        
        willThrow(ConnectException.class).given(taxFactorService).updateMeanTaxFactor(any(Person.class), anyDouble());

	    when(systemUnderTest).processTaxDataFor(new Person());

        assertThat(caughtException(), notNullValue());
        assertThat(caughtException().getCause(), instanceOf(ConnectException.class));
    }
	
}


