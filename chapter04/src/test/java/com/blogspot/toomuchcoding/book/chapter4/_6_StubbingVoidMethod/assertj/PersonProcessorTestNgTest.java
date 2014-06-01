package com.blogspot.toomuchcoding.book.chapter4._6_StubbingVoidMethod.assertj;

import com.blogspot.toomuchcoding.book.chapter4.common.voidmethod.PersonProcessor;
import com.blogspot.toomuchcoding.book.chapter4.common.voidmethod.PersonSaver;
import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import com.blogspot.toomuchcoding.person.Person;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.BDDAssertions.then;

@Listeners(MockitoTestNGListener.class)
public class PersonProcessorTestNgTest {

    @Mock PersonSaver personSaver;

    @InjectMocks PersonProcessor systemUnderTest;

    @Test
    public void should_successfully_save_person_data() {
        // when
        boolean updateSuccessful = systemUnderTest.process(new Person());

        // then
        then(updateSuccessful).isTrue();
    }
}


