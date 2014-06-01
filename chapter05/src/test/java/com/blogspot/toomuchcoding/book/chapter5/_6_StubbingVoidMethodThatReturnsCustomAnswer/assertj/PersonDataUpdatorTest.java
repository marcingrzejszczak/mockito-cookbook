package com.blogspot.toomuchcoding.book.chapter5._6_StubbingVoidMethodThatReturnsCustomAnswer.assertj;

import static com.googlecode.catchexception.CatchException.*;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.*;
import static com.googlecode.catchexception.apis.CatchExceptionAssertJ.when;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;

import java.net.ConnectException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.blogspot.toomuchcoding.book.chapter5.exception.UndefinedCountryException;
import com.blogspot.toomuchcoding.book.chapter5.voidmethod.PersonDataUpdator;
import com.blogspot.toomuchcoding.book.chapter5.voidmethod.TaxFactorService;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonDataUpdatorTest {

	@Spy TaxFactorService taxFactorService;

    @InjectMocks PersonDataUpdator systemUnderTest;

    @Test
    public void should_fail_to_update_tax_factor_for_person_due_to_having_undefined_country() throws ConnectException {
        willAnswer(withExceptionForPersonWithUndefinedCountry()).given(taxFactorService).updateMeanTaxFactor(any(Person.class), anyDouble());
        
        when(systemUnderTest).processTaxDataFor(new Person());
	    
	    then(caughtException()).isInstanceOf(UndefinedCountryException.class);
    }

	private Answer withExceptionForPersonWithUndefinedCountry() {
		return new Answer() {
		    @Override
		    public Object answer(InvocationOnMock invocation) throws Throwable {
		        if (invocation.getArguments().length > 0) {
		            Person person = (Person) invocation.getArguments()[0];
		            if (!person.isCountryDefined()) {
		                throw new UndefinedCountryException("Undefined country");
		            }
		        }
		        return null;
		    }
		};
	}
	
}


