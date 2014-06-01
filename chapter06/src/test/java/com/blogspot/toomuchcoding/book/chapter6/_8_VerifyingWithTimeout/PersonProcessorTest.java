package com.blogspot.toomuchcoding.book.chapter6._8_VerifyingWithTimeout;

import com.blogspot.toomuchcoding.book.chapter6._8_VerifyingWithTimeout.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter6._8_VerifyingWithTimeout.PersonSaver;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PersonProcessorTest {

	@Mock PersonSaver personSaver;
	
	@InjectMocks PersonProcessor systemUnderTest;
	
	@Test
	public void should_process_person_within_specified_time() {
		// when
		systemUnderTest.process(new Person());
		
		// then
		verify(personSaver, timeout(1000)).savePerson(any(Person.class));
	}
		
}