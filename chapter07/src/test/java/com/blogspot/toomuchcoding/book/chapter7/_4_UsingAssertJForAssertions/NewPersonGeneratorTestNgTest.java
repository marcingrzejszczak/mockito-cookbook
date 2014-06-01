package com.blogspot.toomuchcoding.book.chapter7._4_UsingAssertJForAssertions;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.blogspot.toomuchcoding.book.chapter7.common.NewIdentityCreator;
import com.blogspot.toomuchcoding.book.chapter7.common.NewPersonGenerator;
import com.blogspot.toomuchcoding.book.chapter7.common.Person;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;

@SuppressWarnings("unchecked")
@Listeners(MockitoTestNGListener.class)
public class NewPersonGeneratorTestNgTest {

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
        assertThat(newPerson).isNotNull().isNotEqualTo(person);
        assertThat(newPerson.getName()).isNotNull().startsWith("And").endsWith("rew");
        assertThat(newPerson.getSiblings()).contains(new Person("Amy", 20), new Person("Alex", 25));
        assertThat(newPerson.getAge()).isGreaterThan(25);
        assertThat(newPerson.getSiblings()).extracting("name", "age").contains(tuple("Amy", 20), tuple("Alex", 25));
    }

}
