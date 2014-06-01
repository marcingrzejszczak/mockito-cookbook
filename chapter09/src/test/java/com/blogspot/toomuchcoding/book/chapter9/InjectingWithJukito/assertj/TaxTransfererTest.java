package com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;

import javax.inject.Inject;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxTransferer;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.blogspot.toomuchcoding.person.Person;

@RunWith(JukitoRunner.class)
public class TaxTransfererTest {

    @Inject
    TaxTransferer taxTransferer;

    @Test
    public void should_transfer_tax_for_person(TaxService taxService) {
        // given
        Person person = new Person();

        // when
        boolean transferSuccessful = taxTransferer.transferTaxFor(person);

        // then
        then(transferSuccessful).isTrue();
        verify(taxService).transferTaxFor(person);
    }

}
