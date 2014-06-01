package com.blogspot.toomuchcoding.book.chapter9.InjectingWithInnerJukitoModule;

import com.blogspot.toomuchcoding.person.Person;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.jukito.TestScope;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(JukitoRunner.class)
public class TaxTransfererUseInnerJukitoModuleTest {

    @Inject TaxTransferer taxTransferer;

    @Inject TaxService taxService;

    public static class Module extends JukitoModule {

        protected void configureTest() {
            bindSpy(TaxService.class).in(TestScope.SINGLETON);
        }

    }

    @Test
    public void should_transfer_tax_for_person() {
        // given
        Person person = new Person();
        doNothing().when(taxService).transferTaxFor(person);

        // when
        boolean transferSuccessful = taxTransferer.transferTaxFor(person);

        // then
        then(transferSuccessful).isTrue();
        verify(taxService).transferTaxFor(person);
    }

}
