package com.blogspot.toomuchcoding.book.chapter5._7_StubbingFinalMethodsWithPowerMock.hamcrest;

import com.blogspot.toomuchcoding.book.chapter5.finalmethod.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter5.finalmethod.PersonSaver;
import com.blogspot.toomuchcoding.person.Person;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.IObjectFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.willDoNothing;

@PrepareForTest(PersonSaver.class)
public class PersonProcessorTestNgTest extends PowerMockTestCase {

    PersonSaver personSaver;
	
    PersonProcessor systemUnderTest;
	
	@BeforeMethod
	public void setup() {
		personSaver = PowerMockito.spy(new PersonSaver());
		systemUnderTest = new PersonProcessor(personSaver);
	}

    @Test
    public void should_successfully_proces_person_with_defined_country() {
        // given       
        willDoNothing().given(personSaver).savePerson(any(Person.class));

        // when
        boolean result = systemUnderTest.process(new Person("POLAND"));

        // then
        assertThat(result, is(true));
    }


	@ObjectFactory
	public IObjectFactory getObjectFactory() {
		return new PowerMockObjectFactory();
	}
	
}
