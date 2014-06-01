package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringockito;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoAnnotatedContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogspot.toomuchcoding.person.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringockitoAnnotatedContextLoader.class, classes = TaxConfiguration.class)
public class TaxTransfererSpringockitoAnnotationsCodeConfigTest {

    @Autowired TaxTransferer taxTransferer;

    @ReplaceWithMock @Autowired TaxService taxService;

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
