package com.blogspot.toomuchcoding.book.chapter8._2_SOLID;

import org.junit.Test;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

import static org.assertj.core.api.BDDAssertions.then;

public class UpdatePersonJsonBuilderTest {

	UpdatePersonJsonBuilder systemUnderTest = new UpdatePersonJsonBuilder();

	@Test
	public void should_build_proper_json_message() {
		// given
		String name = "Lewandowski";
		int age = 25;
		Person person = new Person(name, age);
		String expectedUpdatePersonJson = "{\"name\":\"" + name + "\",\"age\":\"" + age + "\"}";

		// when
		String updatePersonJson = systemUnderTest.build(person);

		// then
		then(expectedUpdatePersonJson).isEqualTo(updatePersonJson);
	}
}