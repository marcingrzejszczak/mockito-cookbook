package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringockito;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogspot.toomuchcoding.person.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/chapter9/InjectingWithSpringockito/application-context.xml",
                                   "/chapter9/InjectingWithSpringockito/mock-application-context.xml"})
public class TaxTransfererSpringockitoNotCompatibleWithMockito1_9_5_XmlConfigurationTest {

    @Autowired TaxTransferer taxTransferer;

    @Autowired TaxService taxService;

    @Test
    @Ignore("ONLY FOR THE TEST TO PASS - Springockito is not compatible in terms of XML with Mockito 1.9.5")
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
