package com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model;

import java.util.List;

public class PersonBuilder {

	private String name;

	private Address address;

	private List<Person> siblings;

	public PersonBuilder name(String name) {
		this.name = name;
		return this;
	}

	public PersonBuilder address(Address address) {
		this.address = address;
		return this;
	}
	
	public PersonBuilder streetNumber(int streetNumber) {
		if(this.address == null) {
			this.address = AddressBuilder.address().streetNumber(streetNumber).build();
		} else {
			this.address.setStreetNumber(streetNumber);
		}
		return this;
	}

	public PersonBuilder siblings(List<Person> siblings) {
		this.siblings = siblings;
		return this;
	}

	public Person build() {
		Person person = new Person();
		person.setName(name);
		person.setAddress(address);
		person.setSiblings(siblings);
		return person;
	}
	
	public static PersonBuilder person() {
		return new PersonBuilder();
	} 
}