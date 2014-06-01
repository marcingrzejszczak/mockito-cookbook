package com.blogspot.toomuchcoding.book.chapter7._1_UsingHamcrestMatchersForAssertions;

import static java.util.Arrays.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.beans.HasPropertyWithValue.*;
import static org.hamcrest.number.OrderingComparison.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.blogspot.toomuchcoding.book.chapter7.common.NewIdentityCreator;
import com.blogspot.toomuchcoding.book.chapter7.common.NewPersonGenerator;
import com.blogspot.toomuchcoding.book.chapter7.common.Person;

@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
public class NewPersonGeneratorTest {

    @Mock NewIdentityCreator newIdentityCreator;

    @InjectMocks NewPersonGenerator systemUnderTest;

    @Test
    public void should_return_person_with_new_identity() {
        // given
        Person person = new Person("Robert", 25, asList(new Person("John", 10), new Person("Maria", 12)));
        given(newIdentityCreator.createNewName(person)).willReturn("Andrew");
        given(newIdentityCreator.createNewAge(person)).willReturn(45);
        given(newIdentityCreator.createNewSiblings(person)).willReturn(asList(new Person("Amy", 20), new Person("Alex", 25)));

        // when
        Person newPerson = systemUnderTest.generateNewIdentity(person);

        // then
        // core matchers - comes with JUnit 4.9+
        assertThat(newPerson, allOf(notNullValue(), is(not(person))));
        assertThat(newPerson.getName(), both(startsWith("And")).and(endsWith("rew")));
        assertThat(newPerson.getSiblings(), hasItems(new Person("Amy", 20), new Person("Alex", 25)));
        // for more matchers attach org.hamcrest:hamcrest-all
        assertThat(newPerson.getAge(), greaterThan(25));
        assertThat(newPerson, hasProperty("name", equalTo("Andrew")));
    }

}
