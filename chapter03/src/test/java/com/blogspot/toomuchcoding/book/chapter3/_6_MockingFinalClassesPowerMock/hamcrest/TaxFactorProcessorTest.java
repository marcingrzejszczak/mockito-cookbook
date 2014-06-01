package com.blogspot.toomuchcoding.book.chapter3._6_MockingFinalClassesPowerMock.hamcrest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.blogspot.toomuchcoding.book.chapter3._6_MockingFinalClassesPowerMock.TaxFactorProcessor;
import com.blogspot.toomuchcoding.book.chapter3._6_MockingFinalClassesPowerMock.TaxService;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TaxService.class)
public class TaxFactorProcessorTest {

    static final double TAX_FACTOR = 10000;

    @Spy TaxService taxService = new TaxService();

    @InjectMocks TaxFactorProcessor systemUnderTest;

    @Test
    public void should_return_default_tax_factor_for_person_from_undefined_country() {
        // given
        doReturn(TAX_FACTOR).when(taxService).calculateTaxFactorFor(Mockito.any(Person.class));

        // when
        double taxFactorForPerson = systemUnderTest.processTaxFactorFor(new Person());

        // then
	    assertThat(taxFactorForPerson, equalTo(TAX_FACTOR));
    }

}
