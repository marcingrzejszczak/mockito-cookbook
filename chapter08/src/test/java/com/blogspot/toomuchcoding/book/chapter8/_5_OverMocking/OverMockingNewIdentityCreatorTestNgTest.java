package com.blogspot.toomuchcoding.book.chapter8._5_OverMocking;

import com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model.Address;
import com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model.Person;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

public class OverMockingNewIdentityCreatorTestNgTest {
	
	NewIdentityCreator systemUnderTest = new NewIdentityCreator();
	
	@Test
	public void should_generate_new_siblings() {
		// given
		Person person = mock(Person.class);
		List<Person> oldSiblings = mock(List.class);	
		given(person.getSiblings()).willReturn(oldSiblings);
		Iterator<Person> personIterator = mock(Iterator.class);
		given(oldSiblings.iterator()).willReturn(personIterator);
		given(personIterator.hasNext()).willReturn(true, true, true, false);
		given(personIterator.next()).willReturn(createPersonWithName("Amy"),
												createPersonWithName("John"),
												createPersonWithName("Andrew"));

		// when
		List<Person> newSiblings = systemUnderTest.createNewSiblings(person);
		
		// then
		then(newSiblings).isNotSameAs(oldSiblings);
	}

	private Person createPersonWithName(String name) {
		Person person = new Person();
		person.setName(name);
		return person;
	}

	@Test
	public void should_generate_new_address_with_street_number() {
		// given
		Person person = mock(Person.class);
		Address address = mock(Address.class);
		given(person.getAddress()).willReturn(address);
		given(address.getStreetNumber()).willReturn(10);
		
		// when
		int newStreetNumber = systemUnderTest.createNewStreetNumber(person);
		
		// then
		then(newStreetNumber).isNotEqualTo(person.getAddress().getStreetNumber());
	}
	
}