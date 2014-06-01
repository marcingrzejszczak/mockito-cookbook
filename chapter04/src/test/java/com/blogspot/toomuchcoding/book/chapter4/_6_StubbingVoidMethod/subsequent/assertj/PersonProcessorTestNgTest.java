package com.blogspot.toomuchcoding.book.chapter4._6_StubbingVoidMethod.subsequent.assertj;

import com.blogspot.toomuchcoding.book.chapter4.common.exception.FailedToSavedPersonDataException;
import com.blogspot.toomuchcoding.book.chapter4.common.voidmethod.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter4.common.voidmethod.PersonSaver;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;

@Listeners(MockitoTestNGListener.class)
public class PersonProcessorTestNgTest {

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
        then(updateSuccessful).isFalse();
        then(secondUpdateSuccessful).isTrue();
    }
}


