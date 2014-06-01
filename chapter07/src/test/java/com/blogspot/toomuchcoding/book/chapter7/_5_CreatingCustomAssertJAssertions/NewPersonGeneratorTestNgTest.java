package com.blogspot.toomuchcoding.book.chapter7._5_CreatingCustomAssertJAssertions;

import static com.blogspot.toomuchcoding.book.chapter7.common.assertj.MyBddAssertions.*;
import static java.util.Arrays.*;
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
        Person person = new Person("Robert", 25, asList(new Person("John"), new Person("Maria")));
        given(newIdentityCreator.createNewName(person)).willReturn("Andrew");
        given(newIdentityCreator.createNewAge(person)).willReturn(45);
        given(newIdentityCreator.createNewSiblings(person)).willReturn(asList(new Person("Amy"), new Person("Alejandro Gonzales")));

        // when
        Person newPerson = systemUnderTest.generateNewIdentity(person);

        // then
        then(newPerson).isNotEqualTo(person)
                             .hasNameEqualTo("Andrew")
                             .hasAgeGreaterThan(25)
                             .containsSiblings(new Person("Amy"), new Person("Alejandro Gonzales"));
    }

}
