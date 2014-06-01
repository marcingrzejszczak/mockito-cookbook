package com.blogspot.toomuchcoding.book.chapter8._1_ProblemWithNew;

import static java.util.Arrays.*;
import static org.assertj.core.api.BDDAssertions.*;

import java.util.List;

import org.junit.Test;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

public class BadlyDesignedNewPersonGeneratorTest {

    BadlyDesignedNewPersonGenerator systemUnderTest = new BadlyDesignedNewPersonGenerator();

    @Test
    public void should_return_person_with_new_identity() {
        // given
        List<Person> siblings = asList(new Person("John", 10), new Person("Maria", 12));
        Person person = new Person("Robert", 25, siblings);

        // when
        Person newPerson = systemUnderTest.generateNewIdentity(person);

        // then
        then(newPerson).isNotEqualTo(person);
        then(newPerson.getAge()).isNotEqualTo(person.getAge());
        then(newPerson.getName()).isNotEqualTo(person.getName());
        then(newPerson.getSiblings()).doesNotContainAnyElementsOf(siblings);
    }
	
}
