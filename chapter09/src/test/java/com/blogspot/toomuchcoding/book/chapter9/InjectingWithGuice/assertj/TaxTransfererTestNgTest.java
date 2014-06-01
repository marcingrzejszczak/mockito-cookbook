package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxTransferer;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.person.Person;
import com.google.inject.Inject;

@Guice(modules = MockModule.class)
public class TaxTransfererTestNgTest {

    @Inject
    TaxTransferer taxTransferer;

    @Inject
    TaxService taxService;

    @Test
    public void should_transfer_tax_for_person() {
        // given
        Person person = new Person();

        // when
        boolean transferSuccessful = taxTransferer.transferTaxFor(person);

        // then
        then(transferSuccessful).isTrue();
        verify(taxService).transferTaxFor(person);
    }

}
