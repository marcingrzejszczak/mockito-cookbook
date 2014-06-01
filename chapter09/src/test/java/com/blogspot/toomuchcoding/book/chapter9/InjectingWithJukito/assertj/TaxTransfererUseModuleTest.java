package com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.assertj;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.verify;

@RunWith(JukitoRunner.class)
@UseModules({MockModule.class})
public class TaxTransfererUseModuleTest {

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
