package com.blogspot.toomuchcoding.book.chapter5._4_StubbingVoidMethod.assertj;

import static org.assertj.core.api.BDDAssertions.*;
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
    public void should_successfully_update_tax_factor_for_person() throws ConnectException {
        // given
        willDoNothing().given(taxFactorService).updateMeanTaxFactor(any(Person.class), anyDouble());

        // when
        boolean success = systemUnderTest.processTaxDataFor(new Person());
	    
	    // then
	    then(success).isTrue();
    }
	
}


