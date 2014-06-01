package com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod.PersonSaver;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonProcessorTest {

    @Mock
    PersonSaver personSaver;

    @InjectMocks
    PersonProcessor systemUnderTest;

    @Test
    public void should_fail_to_save_person_data_due_to_having_undefined_country() {
        // given
        willCallRealMethod().given(personSaver).savePerson(any(Person.class));

        // when
        boolean updateSuccessful = systemUnderTest.updatePersonData(new Person());

        // then
        then(updateSuccessful).isFalse();
    }
	
}


