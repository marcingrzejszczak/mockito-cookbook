package com.blogspot.toomuchcoding.book.chapter7._3_VerifyingWithMatchers;

import java.util.List;

import com.blogspot.toomuchcoding.book.chapter7.common.Person;

public interface NewIdentityCreator {
    String createNewName(Person person);
    int createNewAge(Person person);
    List<Person> createNewSiblings(Person person);
	void updateDataFor(List<Person> person);
}
