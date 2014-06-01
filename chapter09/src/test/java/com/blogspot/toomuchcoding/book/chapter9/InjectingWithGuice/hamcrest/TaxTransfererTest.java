package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.hamcrest;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TaxTransfererTest {

    TaxTransferer taxTransferer;

    TaxService taxService;

    /**
     * You can also do it like this:
     * Guice.createInjector(Modules.override(new ProductionModule()).with(new TestModule()));
     *
     * But as the javadoc for Modules.overrides(..) recommends, you should design your modules
     * in such a way that you don't need to override bindings. Solution: move classes to be mocked
     * to separate modules
     */
    @Before
    public void setup() {
        Injector injector = Guice.createInjector(new MockModule());
        taxTransferer = injector.getInstance(TaxTransferer.class);
        taxService = injector.getInstance(TaxService.class);
    }

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
