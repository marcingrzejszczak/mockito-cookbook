package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpring;

import com.blogspot.toomuchcoding.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.verify;

@ContextConfiguration(locations = {"/chapter9/InjectingWithSpring/application-context.xml",
                                   "/chapter9/InjectingWithSpring/mock-application-context.xml"})
public class TaxTransfererXmlConfigurationTestNgTest extends AbstractTestNGSpringContextTests {

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
