package com.blogspot.toomuchcoding.book.chapter7._3_VerifyingWithMatchers;

import java.util.ArrayList;
import java.util.List;

import com.blogspot.toomuchcoding.book.chapter7.common.Person;

public class NewPersonGenerator {

    private final NewIdentityCreator newIdentityCreator;

    public NewPersonGenerator(NewIdentityCreator newIdentityCreator) {
        this.newIdentityCreator = newIdentityCreator;
    }

    public List<Person> generateNewIdentities(List<Person> people) {
        List<Person> newPeople = new ArrayList<Person>();
	    for(Person person : people) {
		    String newName = newIdentityCreator.createNewName(person);
		    int newAge = newIdentityCreator.createNewAge(person);
		    List<Person> newSiblings = newIdentityCreator.createNewSiblings(person);
		    Person newPerson = new Person(newName, newAge, newSiblings);
		    newPeople.add(newPerson);
	    }
	    newIdentityCreator.updateDataFor(newPeople);
	    return newPeople;
    }
	
}
