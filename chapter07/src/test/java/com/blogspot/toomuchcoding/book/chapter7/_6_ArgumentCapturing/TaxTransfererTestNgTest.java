package com.blogspot.toomuchcoding.book.chapter7._6_ArgumentCapturing;

import static com.blogspot.toomuchcoding.common.assertj.MyBddAssertions.*;
import static org.mockito.Mockito.*;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.person.Person;

public class TaxTransfererTestNgTest {

    TaxService taxService = Mockito.mock(TaxService.class);

    TaxTransferer systemUnderTest = new TaxTransferer(taxService);

    ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);

    @Test
    public void should_change_persons_country_before_sending_data_through_ws() {
        // when
        systemUnderTest.transferTaxFor(new Person("Lewandowski", "UK"));

        // then
        verify(taxService).transferTaxFor(personCaptor.capture());
        then(personCaptor.getValue()).hasName("Lewandowski").hasCountry(TaxTransferer.POLAND);
    }

}
