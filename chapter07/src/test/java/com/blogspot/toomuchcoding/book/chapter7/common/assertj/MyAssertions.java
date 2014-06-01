package com.blogspot.toomuchcoding.book.chapter7.common.assertj;

import org.assertj.core.api.Assertions;

import com.blogspot.toomuchcoding.book.chapter7.common.Person;

public class MyAssertions extends Assertions {

    public static PersonAssert assertThat(Person actual) {
        return new PersonAssert(actual);
    }

}
