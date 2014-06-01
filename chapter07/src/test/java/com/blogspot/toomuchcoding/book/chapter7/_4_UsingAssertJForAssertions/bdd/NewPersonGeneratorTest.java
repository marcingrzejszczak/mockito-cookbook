package com.blogspot.toomuchcoding.book.chapter7._4_UsingAssertJForAssertions.bdd;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.BDDAssertions.*;
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
        then(newPerson).isNotNull().isNotEqualTo(person);
        then(newPerson.getName()).isNotNull().startsWith("And").endsWith("rew");
        then(newPerson.getSiblings()).contains(new Person("Amy", 20), new Person("Alex", 25));
        then(newPerson.getAge()).isGreaterThan(25);
        then(newPerson.getSiblings()).extracting("name", "age").contains(tuple("Amy", 20), tuple("Alex", 25));
    }

}
