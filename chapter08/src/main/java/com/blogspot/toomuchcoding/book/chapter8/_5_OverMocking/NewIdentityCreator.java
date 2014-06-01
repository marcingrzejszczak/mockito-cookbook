package com.blogspot.toomuchcoding.book.chapter8._5_OverMocking;

import java.util.ArrayList;
import java.util.List;

import com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model.Person;

class NewIdentityCreator {

	public String createNewName(Person person) {
        return person.getName() + "_new";
    }

	public int createNewStreetNumber(Person person) {
        return person.getAddress().getStreetNumber() + 5;
    }

    public List<Person> createNewSiblings(Person person) {
        List<Person> newSiblings = new ArrayList<Person>();
	    for(Person sibling : person.getSiblings()) {
		    Person newPerson = new Person();
		    person.setName(createNewName(sibling));
		    person.setAddress(sibling.getAddress());
		    person.setSiblings(sibling.getSiblings());
		    newSiblings.add(newPerson);
        }	    
	    return newSiblings;
    }

}
