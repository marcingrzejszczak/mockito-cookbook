package com.blogspot.toomuchcoding.book.chapter3._6_MockingFinalClassesPowerMock.assertj;

import com.blogspot.toomuchcoding.book.chapter3._6_MockingFinalClassesPowerMock.TaxFactorProcessor;
import com.blogspot.toomuchcoding.book.chapter3._6_MockingFinalClassesPowerMock.TaxService;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.doReturn;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TaxService.class)
public class TaxFactorProcessorTest {

    static final double TAX_FACTOR = 10000;

    @Spy TaxService taxService = new TaxService();

    @InjectMocks
    TaxFactorProcessor systemUnderTest;

    @Test
    public void should_return_default_tax_factor_for_person_from_undefined_country() {
        // given
        doReturn(TAX_FACTOR).when(taxService).calculateTaxFactorFor(Mockito.any(Person.class));

        // when
        double taxFactorForPerson = systemUnderTest.processTaxFactorFor(new Person());

        // then
        then(taxFactorForPerson).isEqualTo(TAX_FACTOR);
    }

}
