package com.blogspot.toomuchcoding.book.chapter5.finalmethod;

import com.blogspot.toomuchcoding.person.Person;

public class PersonProcessor {

    private final PersonSaver personSaver;

    public PersonProcessor(PersonSaver personSaver) {
        this.personSaver = personSaver;
    }

    public boolean process(Person person) {
        try {
	        personSaver.validatePerson(person);
            personSaver.savePerson(person);
            return true;
        } catch (Exception exception) {
            System.err.printf("Exception occurred while trying save person [%s]%n", exception);
            return false;
        }
    }

}
