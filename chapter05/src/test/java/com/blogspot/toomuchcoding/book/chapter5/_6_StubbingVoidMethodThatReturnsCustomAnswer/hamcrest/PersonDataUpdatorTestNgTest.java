package com.blogspot.toomuchcoding.book.chapter5._6_StubbingVoidMethodThatReturnsCustomAnswer.hamcrest;

import com.blogspot.toomuchcoding.book.chapter5.exception.UndefinedCountryException;
import com.blogspot.toomuchcoding.book.chapter5.voidmethod.PersonDataUpdator;
import com.blogspot.toomuchcoding.book.chapter5.voidmethod.TaxFactorService;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.ConnectException;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.BDDMockito.willAnswer;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;

@Listeners(MockitoTestNGListener.class)
public class PersonDataUpdatorTestNgTest {

	@Spy TaxFactorService taxFactorService;

    @InjectMocks PersonDataUpdator systemUnderTest;

    @Test
    public void should_fail_to_update_tax_factor_for_person_due_to_having_undefined_country() throws ConnectException {
        willAnswer(withExceptionForPersonWithUndefinedCountry()).given(taxFactorService).updateMeanTaxFactor(any(Person.class), anyDouble());
        
        when(systemUnderTest).processTaxDataFor(new Person());

        assertThat(caughtException(), instanceOf(UndefinedCountryException.class));
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


