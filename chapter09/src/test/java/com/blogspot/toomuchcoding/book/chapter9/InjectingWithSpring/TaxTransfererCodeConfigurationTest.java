package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpring;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogspot.toomuchcoding.person.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TaxConfiguration.class, MockTaxConfiguration.class})
public class TaxTransfererCodeConfigurationTest {

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
