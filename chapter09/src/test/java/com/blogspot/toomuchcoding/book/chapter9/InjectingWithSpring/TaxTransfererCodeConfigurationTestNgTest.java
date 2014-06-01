package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpring;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.person.Person;

@ContextConfiguration(classes = {TaxConfiguration.class, MockTaxConfiguration.class})
public class TaxTransfererCodeConfigurationTestNgTest extends AbstractTestNGSpringContextTests {

    @Autowired TaxTransferer taxTransferer;

    @Autowired TaxService taxService;

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
