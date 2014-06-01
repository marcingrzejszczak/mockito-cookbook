package com.blogspot.toomuchcoding.book.chapter7.common.assertj;

import org.assertj.core.api.BDDAssertions;

import com.blogspot.toomuchcoding.book.chapter7.common.Person;

public class MyBddAssertions extends BDDAssertions {

	public static PersonAssert then(Person actual) {
		return new PersonAssert(actual);
	}

}
