package com.blogspot.toomuchcoding.book.chapter4.common.voidmethod;

import com.blogspot.toomuchcoding.book.chapter4.common.exception.FailedToSavedPersonDataException;
import com.blogspot.toomuchcoding.person.Person;

public class PersonProcessor {

    private final PersonSaver personSaver;

    public PersonProcessor(PersonSaver personSaver) {
        this.personSaver = personSaver;
    }

    public boolean process(Person person) {
        try {
            personSaver.savePerson(person);
            return true;
        } catch (FailedToSavedPersonDataException e) {
            System.err.printf("Exception occurred while trying save person data [%s]%n", e);
            return false;
        }
    }

}
