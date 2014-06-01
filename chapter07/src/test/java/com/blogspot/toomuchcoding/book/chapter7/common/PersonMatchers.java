package com.blogspot.toomuchcoding.book.chapter7.common;

import static org.mockito.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.TypeSafeMatcher;

public class PersonMatchers {

	public static Matcher hasNameEqualTo(final String name) {
		return new BaseMatcher() {
			@Override
			public boolean matches(Object item) {
				if (!(item instanceof Person)) {
					return false;
				}
				Person person = (Person) item;
				return bothNamesAreNull(person) || bothNamesMatch(person);
			}

			private boolean bothNamesMatch(Person person) {
				return (name != null && name.equals(person.getName()));
			}

			private boolean bothNamesAreNull(Person person) {
				return (name == null && person.getName() == null);
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("Name should be equal to ").appendValue(name);
			}
		};
	}

	public static Matcher<Person> hasAgeGreaterThan(final int age) {
		return new TypeSafeMatcher<Person>() {
			@Override
			protected boolean matchesSafely(Person person) {
				return person.getAge() > age;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("Age should be greater than ").appendValue(age);
			}
		};
	}

	public static Matcher<Person> containsSiblings(final Person... siblings) {
		return new TypeSafeDiagnosingMatcher<Person>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("Person should have siblings ").appendValue(siblings);
			}

			@Override
			protected boolean matchesSafely(Person person, Description mismatchDescription) {
				if (!person.getSiblings().containsAll(Arrays.asList(siblings))) {
					mismatchDescription.appendText("The person has size of siblings equal to ")
							.appendValue(person.getSiblings().size())
							.appendText(" and the person has siblings ")
							.appendValue(person.getSiblings());
					return false;
				}
				return true;
			}
		};
	}
	
	public static List<Person> numberOfMaturePeople(int count) {
		return argThat(containsNumberOfMaturePeople(count));
	}
	
	static Matcher<List<Person>> containsNumberOfMaturePeople(final int count) {
		return new TypeSafeMatcher<List<Person>>() {
			@Override
			protected boolean matchesSafely(List<Person> item) {
				return count == countMaturePeople(item);
			}

			@Override
			public void describeTo(Description description) { 
				description.appendText("Number of mature people should be equal to ")
						   .appendValue(count);
			}
			
			private int countMaturePeople(List<Person> people) {
				int maturePeopleCount = 0;
				for(Person person : people) {
					if (person.getAge() >= 18) {
						maturePeopleCount = maturePeopleCount + 1;
					}
				}
				return maturePeopleCount;
			}
		};				
	}
	
}
