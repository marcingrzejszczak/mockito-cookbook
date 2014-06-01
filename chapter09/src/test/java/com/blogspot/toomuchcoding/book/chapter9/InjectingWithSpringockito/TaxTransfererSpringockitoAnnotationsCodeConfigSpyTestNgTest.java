package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringockito;

import com.blogspot.toomuchcoding.person.Person;
import org.kubek2k.springockito.annotations.SpringockitoAnnotatedContextLoader;
import org.kubek2k.springockito.annotations.WrapWithSpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ContextConfiguration(loader = SpringockitoAnnotatedContextLoader.class, classes = TaxConfiguration.class)
public class TaxTransfererSpringockitoAnnotationsCodeConfigSpyTestNgTest extends AbstractTestNGSpringContextTests {

    @Autowired TaxTransferer taxTransferer;

    @WrapWithSpy @Autowired TaxService taxService;

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
