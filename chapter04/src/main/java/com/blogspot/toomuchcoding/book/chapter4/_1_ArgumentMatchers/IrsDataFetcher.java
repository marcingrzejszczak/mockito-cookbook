package com.blogspot.toomuchcoding.book.chapter4._1_ArgumentMatchers;

import com.blogspot.toomuchcoding.person.Person;

public interface IrsDataFetcher {

    boolean isIrsApplicable(Person person, String city);

}
