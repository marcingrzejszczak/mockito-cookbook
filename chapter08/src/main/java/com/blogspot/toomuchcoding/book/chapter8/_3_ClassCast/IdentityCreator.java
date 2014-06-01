package com.blogspot.toomuchcoding.book.chapter8._3_ClassCast;

import com.blogspot.toomuchcoding.book.chapter8.common.Person;

import java.util.List;

public interface IdentityCreator {

    public String createNewName(Person person);

    public int createNewAge(Person person);

    public List<Person> createNewSiblings(Person person);

}
