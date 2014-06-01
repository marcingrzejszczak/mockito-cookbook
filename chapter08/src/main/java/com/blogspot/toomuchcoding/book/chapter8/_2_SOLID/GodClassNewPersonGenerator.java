package com.blogspot.toomuchcoding.book.chapter8._2_SOLID;

import static java.util.Arrays.*;

import java.util.List;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

public class GodClassNewPersonGenerator {

    static final String DEFAULT_NEW_NAME = "NewName";

    public Person generateNewIdentity(Person person) {
        String newName = createNewName(person);
        int newAge = createNewAge(person);
        List<Person> newSiblings = createNewSiblings(person);
        Person newPerson = new Person(newName, newAge, newSiblings);
        updatePersonData(newPerson);
        return newPerson;
    }

    private String createNewName(Person person) {
        System.out.printf("Calling web service and creating new name for person [%s]%n", person.getName());
        return DEFAULT_NEW_NAME;
    }

    private int createNewAge(Person person) {
        System.out.printf("Calling db and creating new age for person [%s]%n", person.getName());
        return person.getAge() + 5;
    }

    private List<Person> createNewSiblings(Person person) {
        System.out.printf("Making heavy IO operations and creating new siblings for person [%s]%n", person.getName());
        return asList(new Person("Bob"), new Person("Andrew"));
    }

    private void updatePersonData(Person person) {
        String json = buildJsonStringToPerformTheUpdate(person);
        System.out.printf("Calling web service to update new identity for person [%s] with JSON String [%s]%n", person.getName(), json);
    }

    private String buildJsonStringToPerformTheUpdate(Person person) {
        return "{\"name\":\""+person.getName()+"\",\"age\":\""+person.getAge()+"\"}";
    }
}
