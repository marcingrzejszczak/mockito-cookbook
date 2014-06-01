package com.blogspot.toomuchcoding.book.chapter8._1_ProblemWithNew;

import static java.util.Arrays.*;
import static org.assertj.core.api.BDDAssertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BadlyDesignedNewPersonGenerator.class)
public class BadlyDesignedNewPersonGeneratorPowerMockTest {

    BadlyDesignedNewPersonGenerator systemUnderTest = new BadlyDesignedNewPersonGenerator();

    @Test
    public void should_return_person_with_new_identity() throws Exception {
        // given
        List<Person> siblings = asList(new Person("John", 10), new Person("Maria", 12));
        Person person = new Person("Robert", 25, siblings);
        NewIdentityCreator newIdentityCreator = Mockito.mock(NewIdentityCreator.class);
        PowerMockito.whenNew(NewIdentityCreator.class).withAnyArguments().thenReturn(newIdentityCreator);

        // when
        Person newPerson = systemUnderTest.generateNewIdentity(person);

        // then
        then(newPerson).isNotEqualTo(person);
        then(newPerson.getAge()).isNotEqualTo(person.getAge());
        then(newPerson.getName()).isNotEqualTo(person.getName());
        then(newPerson.getSiblings()).doesNotContainAnyElementsOf(siblings);
    }
	
}
