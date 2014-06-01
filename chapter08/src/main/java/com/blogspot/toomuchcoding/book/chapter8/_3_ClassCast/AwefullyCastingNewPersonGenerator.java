package com.blogspot.toomuchcoding.book.chapter8._3_ClassCast;

import java.util.List;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

public class AwefullyCastingNewPersonGenerator {

    private final IdentityCreator identityCreator;

    public AwefullyCastingNewPersonGenerator(IdentityCreator identityCreator) {
        this.identityCreator = identityCreator;
    }

    public Person generateNewIdentity(Person person) {
        String newName = identityCreator.createNewName(person);
        int newAge = identityCreator.createNewAge(person);
        List<Person> newSiblings = identityCreator.createNewSiblings(person);
        Person newPerson = new Person(newName, newAge, newSiblings);
        if (identityCreator instanceof PersonDataUpdater) {
            ((PersonDataUpdater) identityCreator).updatePersonData(newPerson);
        }
        return newPerson;
    }
	
}
