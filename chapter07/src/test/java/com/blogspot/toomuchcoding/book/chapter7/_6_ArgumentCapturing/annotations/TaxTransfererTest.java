package com.blogspot.toomuchcoding.book.chapter7._6_ArgumentCapturing.annotations;

import static com.blogspot.toomuchcoding.common.assertj.MyBddAssertions.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter7._6_ArgumentCapturing.TaxService;
import com.blogspot.toomuchcoding.book.chapter7._6_ArgumentCapturing.TaxTransferer;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class TaxTransfererTest {

    @Mock TaxService taxService;

    @InjectMocks TaxTransferer systemUnderTest;

    @Captor ArgumentCaptor<Person> personCaptor;

    @Test
    public void should_change_persons_country_before_sending_data_through_ws() {
        // when
        systemUnderTest.transferTaxFor( new Person("Lewandowski", "UK"));

        // then
        verify(taxService).transferTaxFor(personCaptor.capture());
	    then(personCaptor.getValue()).hasName("Lewandowski").hasCountry("Poland");
    }
	
}
