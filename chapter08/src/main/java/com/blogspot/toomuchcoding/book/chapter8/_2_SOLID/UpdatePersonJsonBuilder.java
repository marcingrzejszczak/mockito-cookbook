package com.blogspot.toomuchcoding.book.chapter8._2_SOLID;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

class UpdatePersonJsonBuilder {

	public String build(Person person) {
		return "{\"name\":\"" + person.getName() + "\",\"age\":\"" + person.getAge() + "\"}";
	}
	
}
