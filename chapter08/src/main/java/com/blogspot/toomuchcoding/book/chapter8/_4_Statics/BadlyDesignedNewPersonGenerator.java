package com.blogspot.toomuchcoding.book.chapter8._4_Statics;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

import java.util.List;

public class BadlyDesignedNewPersonGenerator {

    public Person generateNewIdentity(Person person) {
        String newName = StaticIdentityCreator.createNewName(person);
        int newAge = StaticIdentityCreator.createNewAge(person);
        List<Person> newSiblings = StaticIdentityCreator.createNewSiblings(person);
        return new Person(newName, newAge, newSiblings);
    }

}
