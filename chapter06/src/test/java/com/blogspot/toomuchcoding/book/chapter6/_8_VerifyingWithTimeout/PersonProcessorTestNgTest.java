package com.blogspot.toomuchcoding.book.chapter6._8_VerifyingWithTimeout;

import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@Listeners(MockitoTestNGListener.class)
public class PersonProcessorTestNgTest {

	@Mock  PersonSaver personSaver;
	
	@InjectMocks PersonProcessor systemUnderTest;
	
	@Test
	public void should_process_person_within_specified_time() {
		// when
		systemUnderTest.process(new Person());
		
		// then
		verify(personSaver, timeout(1000)).savePerson(any(Person.class));
	}
		
}