package com.blogspot.toomuchcoding.book.chapter8._2_SOLID;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

public class PersonDataUpdater {

	private final UpdatePersonJsonBuilder updatePersonJsonBuilder;

	public PersonDataUpdater(UpdatePersonJsonBuilder updatePersonJsonBuilder) {
		this.updatePersonJsonBuilder = updatePersonJsonBuilder;
	}

	public void updatePersonData(Person person) {
        String json = updatePersonJsonBuilder.build(person);
        System.out.printf("Calling web service to update new identity for person [%s] with JSON String [%s]%n", person.getName(), json);
    }

}
