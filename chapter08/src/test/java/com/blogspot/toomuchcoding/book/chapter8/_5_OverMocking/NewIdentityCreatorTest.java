package com.blogspot.toomuchcoding.book.chapter8._5_OverMocking;

import static com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model.PersonBuilder.*;
import static java.util.Arrays.*;
import static org.assertj.core.api.BDDAssertions.*;

import java.util.List;

import org.junit.Test;

import com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model.Person;

public class NewIdentityCreatorTest {

	NewIdentityCreator systemUnderTest = new NewIdentityCreator();

	@Test
	public void should_generate_new_siblings() {
		// given
		List<Person> oldSiblings = createSiblings();
		Person person = createPersonWithStreetNumberAndSiblingsAndName(oldSiblings);

		// when
		List<Person> siblings = systemUnderTest.createNewSiblings(person);

		// then
		then(siblings).doesNotContainAnyElementsOf(oldSiblings);
	}

	private Person createPersonWithStreetNumberAndSiblingsAndName(List<Person> siblings) {
		return person().streetNumber(10)
				.siblings(siblings)
				.name("Robert")					   
				.build();
	}

	private List<Person> createSiblings() {
		return asList(
				person().name("Amy").build(),
				person().name("John").build(),
				person().name("Andrew").build()
		);
	}

	@Test
	public void should_generate_new_name() {
		// given
		Person person = createPersonWithName();

		// when
		String newName = systemUnderTest.createNewName(person);

		// then
		then(newName).isNotEqualTo(person.getName());
	}

	private Person createPersonWithName() {
		return person().name("Robert").build();
	}

	@Test
	public void should_generate_new_street_number() {
		// given
		Person person = createPersonWithStreetNumber(10);

		// when
		int newStreetNumber = systemUnderTest.createNewStreetNumber(person);

		// then
		then(newStreetNumber).isNotEqualTo(person.getAddress().getStreetNumber());
	}

	private Person createPersonWithStreetNumber(int oldStreetNumber) {
		return person().streetNumber(oldStreetNumber).build();
	}

}