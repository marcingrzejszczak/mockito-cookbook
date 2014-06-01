package com.blogspot.toomuchcoding.book.chapter8._5_OverMocking;

import java.util.ArrayList;
import java.util.List;

import com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model.Person;
import com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model.PersonBuilder;

class RefactoredNewIdentityCreator {

	private final PersonBuilder personBuilder;

	public RefactoredNewIdentityCreator(PersonBuilder personBuilder) {
		this.personBuilder = personBuilder;
	}

	public String createNewName(Person person) {
        return person.getName() + "_new";
    }

	public int createNewStreetNumber(Person person) {
        return person.getAddress().getStreetNumber() + 5;
    }

    public List<Person> createNewSiblings(Person person) {
        List<Person> newSiblings = new ArrayList<Person>();
	    for(Person sibling : person.getSiblings()) {
		    Person newPerson = personBuilder.name(createNewName(sibling))
					                        .address(sibling.getAddress())
					                        .siblings(sibling.getSiblings())
					                        .build();
		    newSiblings.add(newPerson);
        }	    
	    return newSiblings;
    }

}
