package com.blogspot.toomuchcoding.book.chapter8._4_Statics;

import java.util.List;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

public class RefactoredNewPersonGenerator {

    private final NewIdentityCreator newIdentityCreator;

    public RefactoredNewPersonGenerator(NewIdentityCreator newIdentityCreator) {
        this.newIdentityCreator = newIdentityCreator;
    }

    public Person generateNewIdentity(Person person) {
        String newName = newIdentityCreator.createNewName(person);
        int newAge = newIdentityCreator.createNewAge(person);
        List<Person> newSiblings = newIdentityCreator.createNewSiblings(person);
        return new Person(newName, newAge, newSiblings);
    }
	
}
