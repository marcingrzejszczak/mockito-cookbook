package com.blogspot.toomuchcoding.book.chapter4._6_StubbingVoidMethod.subsequent.hamcrest;

import com.blogspot.toomuchcoding.book.chapter4.common.exception.FailedToSavedPersonDataException;
import com.blogspot.toomuchcoding.book.chapter4.common.voidmethod.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter4.common.voidmethod.PersonSaver;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class PersonProcessorTest {

    @Mock PersonSaver personSaver;

    @InjectMocks PersonProcessor systemUnderTest;

    @Test
    public void should_first_fail_to_save_person_data_and_then_succeed() {
        // given
        willThrow(FailedToSavedPersonDataException.class).willNothing().given(personSaver).savePerson(any(Person.class));

        // when
        boolean updateSuccessful = systemUnderTest.process(new Person());
        boolean secondUpdateSuccessful = systemUnderTest.process(new Person());

        // then
        assertThat(updateSuccessful, equalTo(false));
        assertThat(secondUpdateSuccessful, equalTo(true));
    }
}


