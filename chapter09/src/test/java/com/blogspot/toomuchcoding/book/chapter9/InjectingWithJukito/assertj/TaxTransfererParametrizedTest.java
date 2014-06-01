package com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;

import javax.inject.Inject;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxTransferer;
import org.jukito.All;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.blogspot.toomuchcoding.person.Person;

@RunWith(JukitoRunner.class)
public class TaxTransfererParametrizedTest {

    @Inject
    TaxTransferer taxTransferer;

    public static class Module extends JukitoModule {

        protected void configureTest() {
            bindManyInstances(Person.class,
                    new Person(),
                    new Person("Poland"),
                    new Person("France"),
                    new Person("Germany"));
        }

    }

    @Test
    public void should_transfer_tax_for_person(TaxService taxService, @All Person person) {
        // when
        boolean transferSuccessful = taxTransferer.transferTaxFor(person);

        // then
        then(transferSuccessful).isTrue();
        verify(taxService).transferTaxFor(person);
    }
}
