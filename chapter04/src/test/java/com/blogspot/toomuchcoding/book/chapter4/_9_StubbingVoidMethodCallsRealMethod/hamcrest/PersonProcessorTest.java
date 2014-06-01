package com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod.hamcrest;

import com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod.PersonSaver;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.willCallRealMethod;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class PersonProcessorTest {

    @Mock PersonSaver personSaver;

    @InjectMocks PersonProcessor systemUnderTest;

    @Test
    public void should_fail_to_save_person_data_due_to_having_undefined_country() {
        // given
        willCallRealMethod().given(personSaver).savePerson(any(Person.class));

        // when
        boolean updateSuccessful = systemUnderTest.updatePersonData(new Person());

        // then
        assertThat(updateSuccessful, equalTo(false));
    }
	
}


