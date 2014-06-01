package com.blogspot.toomuchcoding.book.chapter8._3_ClassCast;

import java.util.List;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

public class RefactoredNewPersonGenerator {

    private final IdentityCreator identityCreator;

    private final PersonDataUpdater personDataUpdater;

    public RefactoredNewPersonGenerator(IdentityCreator identityCreator, PersonDataUpdater personDataUpdater) {
        this.identityCreator = identityCreator;
        this.personDataUpdater = personDataUpdater;
    }

    public Person generateNewIdentity(Person person) {
        String newName = identityCreator.createNewName(person);
        int newAge = identityCreator.createNewAge(person);
        List<Person> newSiblings = identityCreator.createNewSiblings(person);
        Person newPerson = new Person(newName, newAge, newSiblings);
        personDataUpdater.updatePersonData(newPerson);
        return newPerson;
    }
	
}
