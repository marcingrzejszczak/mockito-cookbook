package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.hamcrest;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

@Guice(modules = MockModule.class)
public class TaxTransfererTestNgTest {

    @Inject TaxTransferer taxTransferer;

    @Inject TaxService taxService;

    @Test
    public void should_transfer_tax_for_person() {
        // given
        Person person = new Person();

        // when
        boolean transferSuccessful = taxTransferer.transferTaxFor(person);

        // then
        assertThat(transferSuccessful, is(true));
        verify(taxService).transferTaxFor(person);
    }

}
