package com.blogspot.toomuchcoding.book.chapter7.common;

import java.util.List;

public interface NewIdentityCreator {
    String createNewName(Person person);
    int createNewAge(Person person);
    List<Person> createNewSiblings(Person person);
}
