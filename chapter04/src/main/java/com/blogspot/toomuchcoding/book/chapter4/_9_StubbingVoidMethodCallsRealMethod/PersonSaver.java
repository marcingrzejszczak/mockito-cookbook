package com.blogspot.toomuchcoding.book.chapter4._9_StubbingVoidMethodCallsRealMethod;

import com.blogspot.toomuchcoding.book.chapter4.common.exception.FailedToSavedPersonDataException;
import com.blogspot.toomuchcoding.person.Person;

public class PersonSaver {

    public void savePerson(Person person) {
        if (!person.isCountryDefined()) {
            throw new FailedToSavedPersonDataException("Invalid input data");
        }
    }

}


