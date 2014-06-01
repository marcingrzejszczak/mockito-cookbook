package com.blogspot.toomuchcoding.book.chapter8._1_ProblemWithNew;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

import java.util.List;

import static java.util.Arrays.asList;

class NewIdentityCreator {

    public static final String DEFAULT_NEW_NAME = "NewName";

    public String createNewName(Person person) {
        System.out.printf("Calling web service and creating new name for person [%s]%n", person.getName());
        return DEFAULT_NEW_NAME;
    }

    public int createNewAge(Person person) {
        System.out.printf("Calling db and creating new age for person [%s]%n", person.getName());
        return person.getAge() + 5;
    }

    public List<Person> createNewSiblings(Person person) {
        System.out.printf("Making heavy IO operations and creating new siblings for person [%s]%n", person.getName());
        return asList(new Person("Bob"), new Person("Andrew"));
    }

}
