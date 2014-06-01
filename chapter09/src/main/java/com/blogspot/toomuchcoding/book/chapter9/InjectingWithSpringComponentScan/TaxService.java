package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringComponentScan;

import com.blogspot.toomuchcoding.person.Person;
import org.springframework.stereotype.Component;

@Component
class TaxService {

    public void transferTaxFor(Person person) {
        System.out.printf("Calling external web service from @Component annotated class for person with name [%s]%n", person.getName());
    }

}
