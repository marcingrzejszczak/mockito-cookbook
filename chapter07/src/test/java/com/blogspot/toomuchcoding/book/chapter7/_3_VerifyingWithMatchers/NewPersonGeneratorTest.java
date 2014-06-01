package com.blogspot.toomuchcoding.book.chapter7._3_VerifyingWithMatchers;

import static com.blogspot.toomuchcoding.book.chapter7.common.PersonMatchers.*;
import static java.util.Arrays.*;
import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter7.common.Person;

@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
public class NewPersonGeneratorTest {

    @Mock NewIdentityCreator newIdentityCreator;

    @InjectMocks NewPersonGenerator systemUnderTest;

    @Test
    public void should_update_data_for_a_single_generated_mature_person() {
        // given
        Person robert = new Person("Robert", 25);
        Person anna = new Person("Anna", 35);
	    List<Person> oldPeople = asList(robert, anna);
	    given(newIdentityCreator.createNewAge(argThat(hasAgeGreaterThan(30)))).willReturn(18);       

        // when
        systemUnderTest.generateNewIdentities(oldPeople);

        // then
        verify(newIdentityCreator).updateDataFor(numberOfMaturePeople(1));
    }
	
}
