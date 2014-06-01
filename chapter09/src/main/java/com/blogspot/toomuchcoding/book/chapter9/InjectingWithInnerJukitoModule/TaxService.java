package com.blogspot.toomuchcoding.book.chapter9.InjectingWithInnerJukitoModule;

import com.blogspot.toomuchcoding.book.chapter9.exception.CustomException;
import com.blogspot.toomuchcoding.person.Person;

class TaxService {

    public void transferTaxFor(Person person) {
        throw new CustomException();
    }

}
