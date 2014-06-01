package com.blogspot.toomuchcoding.book.chapter5._7_StubbingFinalMethodsWithPowerMock.assertj;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.blogspot.toomuchcoding.book.chapter5.finalmethod.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter5.finalmethod.PersonSaver;
import com.blogspot.toomuchcoding.person.Person;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PersonSaver.class)
public class PersonProcessorTest {

    PersonSaver personSaver = PowerMockito.spy(new PersonSaver());

    PersonProcessor systemUnderTest = new PersonProcessor(personSaver);

    @Test
    public void should_successfully_proces_person_with_defined_country() {
        // given       
        willDoNothing().given(personSaver).savePerson(any(Person.class));

        // when
        boolean result = systemUnderTest.process(new Person("POLAND"));

        // then
        then(result).isTrue();
    }
	
}
