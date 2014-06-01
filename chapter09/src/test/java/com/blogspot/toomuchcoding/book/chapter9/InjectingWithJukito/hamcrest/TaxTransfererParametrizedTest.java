package com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.hamcrest;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import org.jukito.All;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

@RunWith(JukitoRunner.class)
public class TaxTransfererParametrizedTest {

    @Inject TaxTransferer taxTransferer;

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
        assertThat(transferSuccessful, is(true));
        verify(taxService).transferTaxFor(person);
    }
}
