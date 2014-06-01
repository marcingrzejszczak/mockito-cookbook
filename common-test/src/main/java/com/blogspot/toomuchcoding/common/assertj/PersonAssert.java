package com.blogspot.toomuchcoding.common.assertj;

import com.blogspot.toomuchcoding.person.Person;
import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

	protected PersonAssert(Person actual) {
		super(actual, PersonAssert.class);
	}

	public PersonAssert hasName(String name) {
        String actualName = actual.getName();
        assertThat(actualName).isEqualTo(name);
        return this;
	}

	public PersonAssert hasCountry(String country) {
        String actualCountry = actual.getCountryName();
        assertThat(actualCountry).isEqualTo(country);
        return this;
	}
}
