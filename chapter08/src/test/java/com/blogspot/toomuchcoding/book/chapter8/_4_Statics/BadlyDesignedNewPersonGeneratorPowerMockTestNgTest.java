package com.blogspot.toomuchcoding.book.chapter8._4_Statics;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.BDDAssertions.then;

@PrepareForTest(StaticIdentityCreator.class)
public class BadlyDesignedNewPersonGeneratorPowerMockTestNgTest extends PowerMockTestCase {

    BadlyDesignedNewPersonGenerator systemUnderTest = new BadlyDesignedNewPersonGenerator();

    @Test
    public void should_return_person_with_new_identity() throws Exception {
        // given
        List<Person> siblings = asList(new Person("John", 10), new Person("Maria", 12));
        Person person = new Person("Robert", 25, siblings);
        PowerMockito.mockStatic(StaticIdentityCreator.class);

        // when
        Person newPerson = systemUnderTest.generateNewIdentity(person);

        // then
        then(newPerson).isNotNull().isNotEqualTo(person);
        then(newPerson.getAge()).isNotEqualTo(person.getAge());
        then(newPerson.getName()).isNotEqualTo(person.getName());
        then(newPerson.getSiblings()).doesNotContainAnyElementsOf(siblings);
    }

    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new PowerMockObjectFactory();
    }

}
