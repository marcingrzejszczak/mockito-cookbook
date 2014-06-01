package com.blogspot.toomuchcoding.book.chapter8._5_OverMocking;

import com.blogspot.toomuchcoding.book.chapter8._5_OverMocking.model.Person;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.*;

public class DeepStubbingNewIdentityCreatorTestNgTest {
	
	NewIdentityCreator systemUnderTest = new NewIdentityCreator();
	
	@Test
	public void should_generate_new_address_with_street_number() {
		// given
		Person person = mock(Person.class, RETURNS_DEEP_STUBS);
		given(person.getAddress().getStreetNumber()).willReturn(10);
		
		// when
		int newStreetNumber = systemUnderTest.createNewStreetNumber(person);
		
		// then
		then(newStreetNumber).isNotEqualTo(person.getAddress().getStreetNumber());
	}


}