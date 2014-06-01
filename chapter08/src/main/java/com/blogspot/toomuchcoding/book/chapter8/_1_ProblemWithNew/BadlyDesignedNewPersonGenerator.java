package com.blogspot.toomuchcoding.book.chapter8._1_ProblemWithNew;

import java.util.List;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

public class BadlyDesignedNewPersonGenerator {

    public Person generateNewIdentity(Person person) {
        NewIdentityCreator newIdentityCreator = new NewIdentityCreator();
        String newName = newIdentityCreator.createNewName(person);
        int newAge = newIdentityCreator.createNewAge(person);
        List<Person> newSiblings = newIdentityCreator.createNewSiblings(person);
        return new Person(newName, newAge, newSiblings);
    }

}
