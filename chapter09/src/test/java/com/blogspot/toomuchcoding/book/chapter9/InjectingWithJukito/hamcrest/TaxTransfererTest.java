package com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.hamcrest;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

@RunWith(JukitoRunner.class)
public class TaxTransfererTest {

    @Inject TaxTransferer taxTransferer;

    @Test
    public void should_transfer_tax_for_person(TaxService taxService) {
        // given
        Person person = new Person();

        // when
        boolean transferSuccessful = taxTransferer.transferTaxFor(person);

        // then
        assertThat(transferSuccessful, is(true));
        verify(taxService).transferTaxFor(person);
    }

}
