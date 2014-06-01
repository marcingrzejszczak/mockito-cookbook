package com.blogspot.toomuchcoding.book.chapter5._4_StubbingVoidMethod.assertj;

import com.blogspot.toomuchcoding.book.chapter5.voidmethod.PersonDataUpdator;
import com.blogspot.toomuchcoding.book.chapter5.voidmethod.TaxFactorService;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.ConnectException;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.*;

@Listeners(MockitoTestNGListener.class)
public class PersonDataUpdatorTestNgTest {

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


