package com.blogspot.toomuchcoding.book.chapter8._3_ClassCast;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.BDDAssertions.then;

@Listeners(MockitoTestNGListener.class)
public class AwfullyCastingNewPersonGeneratorTestNgTest {

    @Mock(extraInterfaces = PersonDataUpdater.class) IdentityCreator identityCreator;

    @InjectMocks AwefullyCastingNewPersonGenerator systemUnderTest;

    @Test
    public void should_return_person_with_new_identity() {
        // given
        List<Person> siblings = asList(new Person("John", 10), new Person("Maria", 12));
        Person person = new Person("Robert", 25, siblings);

        // when
        Person newPerson = systemUnderTest.generateNewIdentity(person);

        // then
        then(newPerson).isNotNull().isNotEqualTo(person);
        then(newPerson.getAge()).isNotEqualTo(person.getAge());
        then(newPerson.getName()).isNotEqualTo(person.getName());
        then(newPerson.getSiblings()).doesNotContainAnyElementsOf(siblings);
    }

}
