package com.blogspot.toomuchcoding.book.chapter7.common.assertj;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.AbstractAssert;

import com.blogspot.toomuchcoding.book.chapter7.common.Person;

public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

	protected PersonAssert(Person actual) {
        super(actual, PersonAssert.class);
	}

	public PersonAssert hasNameEqualTo(String name) {
        String actualName = actual.getName();
        assertThat(actualName).isEqualTo(name);
        return this;
	}

	public PersonAssert hasAgeGreaterThan(int age) {
        int actualAge = actual.getAge();
        assertThat(actualAge).isGreaterThan(age);
        return this;
	}

	public PersonAssert containsSiblings(Person... siblings) {
        List<Person> actualSiblings = actual.getSiblings();
        assertThat(actualSiblings).contains(siblings);
        return this;
	}

}