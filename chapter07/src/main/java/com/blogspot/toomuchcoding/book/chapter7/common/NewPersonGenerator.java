package com.blogspot.toomuchcoding.book.chapter7.common;

import java.util.List;

public class NewPersonGenerator {

    private final NewIdentityCreator newIdentityCreator;

    public NewPersonGenerator(NewIdentityCreator newIdentityCreator) {
        this.newIdentityCreator = newIdentityCreator;
    }

    public Person generateNewIdentity(Person person) {
        String newName = newIdentityCreator.createNewName(person);
        int newAge = newIdentityCreator.createNewAge(person);
        List<Person> newSiblings = newIdentityCreator.createNewSiblings(person);	    
        return new Person(newName, newAge, newSiblings);
    }
}
