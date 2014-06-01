package com.blogspot.toomuchcoding.book.chapter4._1_ArgumentMatchers.hamcrest;

import com.blogspot.toomuchcoding.book.chapter4._1_ArgumentMatchers.IrsDataFetcher;
import com.blogspot.toomuchcoding.book.chapter4._1_ArgumentMatchers.PersonIrsDataVerifier;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.*;

@Listeners(MockitoTestNGListener.class)
public class PersonIrsDataVerifierTestNgTest {

    @Mock IrsDataFetcher irsDataFetcher;

    @InjectMocks PersonIrsDataVerifier systemUnderTest;

    @Test
    public void should_return_true_when_irs_department_is_applicable_for_person_from_warsaw() {
        // given
        String city = "Warsaw";
        given(irsDataFetcher.isIrsApplicable(any(Person.class), eq(city))).willReturn(true);

        // when
        boolean irsApplicable = systemUnderTest.isIrsDepartmentApplicable(new Person(), city);

        // then
        assertThat(irsApplicable, equalTo(true));
    }

    @Test(expectedExceptions = InvalidUseOfMatchersException.class)
    public void should_throw_exception_when_improperly_using_matchers() {
        // expect
        given(irsDataFetcher.isIrsApplicable(any(Person.class), "Warsaw")).willReturn(true);
    }

    @Test
    public void should_return_true_when_irs_department_is_applicable_for_city_starting_with_W() {
        // given
        Person person = new Person();
        given(irsDataFetcher.isIrsApplicable(any(Person.class), startsWith("W"))).willReturn(true);

        // when
        boolean irsApplicable = systemUnderTest.isIrsDepartmentApplicable(person, "Warsaw");

        // then
        assertThat(irsApplicable, equalTo(true));
    }

    @Test
    public void should_return_true_when_irs_department_is_applicable_for_city_ending_with_w() {
        // given
        Person person = new Person();
        given(irsDataFetcher.isIrsApplicable(any(Person.class), endsWith("w"))).willReturn(true);

        // when
        boolean irsApplicable = systemUnderTest.isIrsDepartmentApplicable(person, "Warsaw");

        // then
        assertThat(irsApplicable, equalTo(true));
    }

    @Test
    public void should_return_true_when_irs_department_is_applicable_for_any_city() {
        // given
        Person person = new Person();
        given(irsDataFetcher.isIrsApplicable(any(Person.class), anyString())).willReturn(true);

        // when
        boolean irsApplicable = systemUnderTest.isIrsDepartmentApplicable(person, "Warsaw");

        // then
        assertThat(irsApplicable, equalTo(true));
    }

    @Test
    public void should_return_true_when_irs_department_is_applicable_for_city_containing_rsa() {
        // given
        Person person = new Person();
        given(irsDataFetcher.isIrsApplicable((Person)isNotNull(), contains("rsa"))).willReturn(true);

        // when
        boolean irsApplicable = systemUnderTest.isIrsDepartmentApplicable(person, "Warsaw");

        // then
        assertThat(irsApplicable, equalTo(true));
    }

    @Test
    public void should_return_true_when_irs_department_is_applicable_for_person_from_undefined_country() {
        // given
        Person person = new Person();
        given(irsDataFetcher.isIrsApplicable(refEq(new Person()), anyString())).willReturn(true);

        // when
        boolean irsApplicable = systemUnderTest.isIrsDepartmentApplicable(person, "Warsaw");

        // then
        assertThat(irsApplicable, equalTo(true));
    }

    @Test
    public void should_return_true_when_irs_department_is_applicable() {
        // given
        Person person = new Person();
        given(irsDataFetcher.isIrsApplicable(same(person), anyString())).willReturn(true);

        // when
        boolean irsApplicable = systemUnderTest.isIrsDepartmentApplicable(person, "Warsaw");

        // then
        assertThat(irsApplicable, equalTo(true));
    }

    @Test
    public void should_return_true_when_irs_department_is_applicable_for_person_called_Lewandowski() {
        // given
        Person person = new Person();
        given(irsDataFetcher.isIrsApplicable(argThat(new ArgumentMatcher<Person>() {

            @Override
            public boolean matches(Object argument) {
                return "Lewandowski".equalsIgnoreCase(((Person)argument).getName());
            }

        }), anyString())).willReturn(true);

        // when
        boolean irsApplicable = systemUnderTest.isIrsDepartmentApplicable(person, "Warsaw");

        // then
        assertThat(irsApplicable, equalTo(true));
    }

}


