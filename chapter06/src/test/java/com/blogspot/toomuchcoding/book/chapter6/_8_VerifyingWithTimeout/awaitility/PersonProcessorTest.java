package com.blogspot.toomuchcoding.book.chapter6._8_VerifyingWithTimeout.awaitility;

import com.blogspot.toomuchcoding.book.chapter6._8_VerifyingWithTimeout.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter6._8_VerifyingWithTimeout.PersonSaver;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.Callable;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.mockito.Matchers.any;
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
		await().atMost(1, SECONDS).until(personIsSaved());		
	}

	private Callable<Boolean> personIsSaved() {
		return new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				try {
					verify(personSaver).savePerson(any(Person.class));
					return true;
				} catch (AssertionError assertionError) { 
					return false;
				}
			}
		};
	}

}