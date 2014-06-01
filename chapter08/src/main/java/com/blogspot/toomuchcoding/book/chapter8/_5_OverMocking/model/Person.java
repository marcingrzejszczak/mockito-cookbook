package com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	
	private Address address;
	
	private List<Person> siblings = new ArrayList<Person>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Person> getSiblings() {
		return siblings;
	}

	public void setSiblings(List<Person> siblings) {
		this.siblings = siblings;
	}
	
}
