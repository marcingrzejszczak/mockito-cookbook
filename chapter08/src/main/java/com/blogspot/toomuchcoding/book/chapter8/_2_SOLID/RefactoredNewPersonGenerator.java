package com.blogspot.toomuchcoding.book.chapter8._2_SOLID;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

import java.util.List;

public class RefactoredNewPersonGenerator {

    private final NewIdentityCreator newIdentityCreator;

    private final PersonDataUpdater personDataUpdater;

    public RefactoredNewPersonGenerator(NewIdentityCreator newIdentityCreator, PersonDataUpdater personDataUpdater) {
        this.newIdentityCreator = newIdentityCreator;
        this.personDataUpdater = personDataUpdater;
    }

    public Person generateNewIdentity(Person person) {
        String newName = newIdentityCreator.createNewName(person);
        int newAge = newIdentityCreator.createNewAge(person);
        List<Person> newSiblings = newIdentityCreator.createNewSiblings(person);
        Person newPerson = new Person(newName, newAge, newSiblings);
        personDataUpdater.updatePersonData(newPerson);
        return newPerson;
    }
}
