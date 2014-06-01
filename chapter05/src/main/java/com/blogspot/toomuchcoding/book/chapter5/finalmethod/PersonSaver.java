package com.blogspot.toomuchcoding.book.chapter5.finalmethod;

import com.blogspot.toomuchcoding.person.Person;

public class PersonSaver {

    public void validatePerson(Person person) {
	    if (!person.isCountryDefined()) {
		    System.out.printf("Warning person [%s] has undefined country%n", person.getName());
	    }
    }

	public final void savePerson(Person person) {
		// simulating web service call
		System.out.println("Storing person in the db");
	}

}


