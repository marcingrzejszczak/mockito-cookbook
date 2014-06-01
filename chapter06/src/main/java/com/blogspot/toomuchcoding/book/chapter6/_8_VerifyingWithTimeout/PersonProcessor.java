package com.blogspot.toomuchcoding.book.chapter6._8_VerifyingWithTimeout;

import com.blogspot.toomuchcoding.person.Person;

public class PersonProcessor {

    private final PersonSaver personSaver;

    public PersonProcessor(PersonSaver personSaver) {
        this.personSaver = personSaver;
    }

    public void process(final Person person) {
        new Thread(new Runnable() {
	        @Override
	        public void run() {
		        try {
			        // simulating time consuming actions
			        Thread.sleep(500);
		        } catch (InterruptedException e) {
			        System.err.printf("The thread got interrupted [%s]%n", e);
		        }
		        personSaver.savePerson(person);
	        }
        }).start(); 
    }

}
