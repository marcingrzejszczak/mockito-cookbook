package com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model;

public class AddressBuilder {

	private int streetNumber;

	public AddressBuilder streetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
		return this;
	}
	
	public Address build() {
		Address address = new Address();
		address.setStreetNumber(streetNumber);
		return address;
	}

	public static AddressBuilder address() {
		return new AddressBuilder();
	}
}