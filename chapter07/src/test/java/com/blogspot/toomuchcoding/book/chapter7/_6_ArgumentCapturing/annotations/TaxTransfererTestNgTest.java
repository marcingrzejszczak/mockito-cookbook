package com.blogspot.toomuchcoding.book.chapter7._6_ArgumentCapturing.annotations;

import static com.blogspot.toomuchcoding.common.assertj.MyBddAssertions.*;
import static org.mockito.Mockito.*;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter7._6_ArgumentCapturing.TaxService;
import com.blogspot.toomuchcoding.book.chapter7._6_ArgumentCapturing.TaxTransferer;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;

@Listeners(MockitoTestNGListener.class)
public class TaxTransfererTestNgTest {

    @Mock TaxService taxService;

    @InjectMocks TaxTransferer systemUnderTest;

    @Captor ArgumentCaptor<Person> personCaptor;

    @Test
    public void should_change_persons_country_before_sending_data_through_ws() {
        // when
        systemUnderTest.transferTaxFor(new Person("Lewandowski", "UK"));

        // then
        verify(taxService).transferTaxFor(personCaptor.capture());
	    then(personCaptor.getValue()).hasName("Lewandowski").hasCountry("Poland");
    }
}
